package com.geralt.mafia.web.service.impl;

import com.geralt.mafia.game.GameBoard;
import com.geralt.mafia.web.service.IGameBoardCacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GameBoardCacheServiceImpl implements IGameBoardCacheService {

    /**
     * key 游戏id
     * value 整局游戏的对象
     */
    Cache<Long, GameBoard> gameBoardCache;

    /**
     * 初始化 在构造器后执行
     */
    @PostConstruct
    public void init() {
        gameBoardCache = CacheBuilder.newBuilder().build();
    }


    public void put(long roomId, GameBoard gameBoard) {
        gameBoardCache.put(roomId, gameBoard);
    }

    public GameBoard get(long roomId) {
        return gameBoardCache.getIfPresent(roomId);
    }


}
