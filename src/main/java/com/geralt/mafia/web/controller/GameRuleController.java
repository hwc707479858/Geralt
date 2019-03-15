package com.geralt.mafia.web.controller;

import com.geralt.mafia.game.GameBoard;
import com.geralt.mafia.game.GameStatus;
import com.geralt.mafia.web.service.IGameBoardCacheService;
import com.geralt.web.vo.ResponseData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 游戏规则相关
 */
@RestController
@RequestMapping("/gameRule")
public class GameRuleController {

    @Resource
    private IGameBoardCacheService gameBoardCacheService;

    /**
     * 修改房间游戏规则
     * @param uuId
     * @param roomId
     * @return
     */
    @RequestMapping("/roomId/{roomId}")
    public ResponseData changeRule(String uuId, @PathVariable long roomId, int totalNum, int wolfNum, String[] gods, boolean idoitMastDie)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        GameBoard gameBoard = gameBoardCacheService.get(roomId);
        synchronized (gameBoard) {
            if (!gameBoard.getMasterUuId().equals(uuId)) {
                return ResponseData.newErrorInstance(-1, "您并不是房主");
            }
            if (gameBoard.getPlayerList().size() > totalNum) {
                return ResponseData.newErrorInstance(-1, "当前人数已经超过了设置的人数");
            }
            if (gameBoard.getGameStatus() == GameStatus.IN_THE_GAME || gameBoard.getGameStatus() == GameStatus.GAME_OVER) {
                return ResponseData.newErrorInstance(-1, "游戏已经开始了");
            }
            gameBoard.getGameRule().setGameRule(totalNum, wolfNum, gods, idoitMastDie);
        }
        return ResponseData.newSingleInstance("保存成功");
    }
}
