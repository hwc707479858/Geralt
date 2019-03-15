package com.geralt.mafia.web.controller;

import com.geralt.mafia.config.IdWorker;
import com.geralt.mafia.game.GameBoard;
import com.geralt.mafia.game.GameRule;
import com.geralt.mafia.game.GameStatus;
import com.geralt.mafia.web.service.IGameBoardCacheService;
import com.geralt.web.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创建游戏相关
 */
@Slf4j
@RestController
@RequestMapping("/game")
public class GameBoardController {

    @Resource
    private IGameBoardCacheService gameBoardCacheService;

    @RequestMapping("/create")
    public ResponseData createGame(int totalNum, String password, String gameName, String uuId) {
        try {
            GameBoard gameBoard = GameBoard.builder()
                    .gameStatus(GameStatus.WAIT_FOR_START)
                    .gameRule(GameRule.defaultGameRule(totalNum))
                    .password(password)
                    .gameName(gameName)
                    .masterUuId(uuId).build();
            gameBoardCacheService.put(IdWorker.INSTANCE.nextId(), gameBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseData.newSingleInstance("创建成功");
    }

    public ResponseData startGame() {
        return null;
    }

    public ResponseData joinGame(long roomId) {
        return null;
    }

    //public ResponseData searchGame(String gameName) {}

    public ResponseData leftGame() {
        return null;
    }

}
