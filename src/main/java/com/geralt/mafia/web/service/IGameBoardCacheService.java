package com.geralt.mafia.web.service;

import com.geralt.mafia.game.GameBoard;

/**
 * 管理游戏状态缓存的service
 */
public interface IGameBoardCacheService {

    void put(long roomId, GameBoard gameBoard);

    GameBoard get(long roomId);
}
