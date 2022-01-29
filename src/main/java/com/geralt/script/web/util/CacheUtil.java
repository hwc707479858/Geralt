package com.geralt.script.web.util;

import com.geralt.script.dto.game.Game;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @Author hewenchao
 * @Date 2022/1/29 14:41
 * @Description
 */
public class CacheUtil {
    public static LoadingCache<String, Game> gameCache = null;

    static {
        gameCache = CacheBuilder.newBuilder()
                .expireAfterAccess(30L, TimeUnit.SECONDS)
                .expireAfterWrite(120L,TimeUnit.MINUTES)
                .build(new CacheLoader<String, Game>() {
                            @Override
                            public Game load(String s) throws Exception {
                                return new Game();
                            }
                        });
    }


}
