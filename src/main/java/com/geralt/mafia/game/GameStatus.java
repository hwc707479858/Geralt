package com.geralt.mafia.game;

/**
 * 游戏运行状态
 */
public class GameStatus {

    public static final int WAIT_FOR_PLAYER = 0;

    public static final int WAIT_FOR_START = 1;

    public static final int IN_THE_GAME = 2;

    public static final int GAME_OVER = 3;

    //避免被人实例化
    private GameStatus(){}
}