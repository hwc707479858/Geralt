package com.geralt.script.web.controller;

import com.geralt.script.dto.game.Game;
import com.geralt.script.entity.design.Clue;
import com.geralt.script.entity.design.Role;
import com.geralt.script.entity.design.Script;
import com.geralt.script.service.ClueService;
import com.geralt.script.service.RoleService;
import com.geralt.script.service.ScriptService;
import com.geralt.script.web.util.CacheUtil;
import com.geralt.script.web.vo.SimpleGameVo;
import com.geralt.web.vo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author hewenchao
 * @Date 2022/1/29 13:59
 * @Description
 */
@RestController
@RequestMapping("/script")
public class GameRoomController {

    @Autowired
    private ScriptService scriptService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ClueService clueService;

    //创建游戏
    @PostMapping("/room/{userName}/create/{scriptId}")
    public ResponseData createGame(@PathVariable int scriptId, @PathVariable String userName) {
        String uuid = UUID.randomUUID().toString();
        Script script = scriptService.getById(scriptId);
        List<Role> roles = roleService.listByScriptId(scriptId);
        List<Clue> clues = clueService.listByScriptId(scriptId);
        Game game = new Game();
        game.setId(uuid);
        game.setCreateTime(new Date());
        game.setClues(clues);
        game.setName(userName + "创建的" + script.getName());
        game.setRoles(roles);
        game.setScript(script);
        game.setMaxUserCount(roles.size());
        CacheUtil.gameCache.put(uuid, game);
        return ResponseData.newSingleInstance(game);
    }

    //房间列表
    @GetMapping("/rooms")
    public ResponseData listRoom() {
        ConcurrentMap<String, Game> stringGameConcurrentMap = CacheUtil.gameCache.asMap();
        List<SimpleGameVo> games = new ArrayList<>();
        for (Game g : stringGameConcurrentMap.values()) {
            games.add(SimpleGameVo.initByGame(g));
        }
        return ResponseData.newListInstance(games);
    }

}
