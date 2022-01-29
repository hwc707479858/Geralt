package com.geralt.script.web.controller;

import com.geralt.script.dto.game.Game;
import com.geralt.script.entity.design.Role;
import com.geralt.script.web.util.CacheUtil;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hewenchao
 * @Date 2022/1/29 11:24
 * @Description
 */
@RestController
@MessageMapping("/script/game")
public class GameController {


    //加入房间
    @SendTo("/topic/{roomId}/**")
    @SubscribeMapping("/topic/{roomId}/{userName}")
    public Game join(@DestinationVariable("roomId") String roomId, @DestinationVariable("userName") String userName) {
        synchronized (roomId) {
            Game game = CacheUtil.gameCache.getUnchecked(roomId);
            if (game.getMaxUserCount() > game.getUsers().size()) { //房间还有位置
                game.getUsers().add(userName);
                CacheUtil.gameCache.put(roomId, game);
                return game;
            } else { //TODO 房间没有位置
                return null;
            }
        }
    }

    //选择角色
    @SendTo("/topic/{roomId}/**")
    @MessageMapping("/{roomId}/{userName}/choose/{roleId}")
    public Game chooseRole(@DestinationVariable("roomId") String roomId,
                           @DestinationVariable("userName") String userName, @DestinationVariable("roleId") int roleId) {
        synchronized (roomId) {
            Game game = CacheUtil.gameCache.getUnchecked(roomId);
            Role role = game.getRoles().stream().filter(r -> r.getId() == roleId).findFirst().get();
            game.getUserRoleMap().putIfAbsent(userName, role);
            CacheUtil.gameCache.put(roomId, game);
            return game;
        }
    }


    //开始游戏
    @SendTo("/topic/{roomId}/**")
    @MessageMapping("/start/{roomId}/")
    public Game start(@DestinationVariable("roomId") String roomId) {
        synchronized (roomId) {
            Game game = CacheUtil.gameCache.getUnchecked(roomId);
            game.setStatus(1);
            CacheUtil.gameCache.put(roomId, game);
            return game;
        }
    }

}
