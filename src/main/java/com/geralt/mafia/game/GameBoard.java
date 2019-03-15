package com.geralt.mafia.game;

import com.geralt.mafia.domain.Player;
import com.geralt.mafia.domain.part.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表示一局游戏的实体类
 */
@Setter
@Getter
@Builder
public class GameBoard {

    /**
     * 天数 初始值为1
     */
    private int turnNum = 1;

    /**
     * 警长玩家的号码 如果为0 则表示没有经常
     */
    private int sheriffPlayerNo = 0;

    /**
     * 开始游戏
     */
    private int gameStatus = GameStatus.WAIT_FOR_PLAYER;

    /**
     * 参加本局游戏的玩家
     */
    private List<Player> playerList;

    /**
     * key 号码牌 value 玩家
     */
    private Map<Integer, Player> playerMap = new HashMap();

    /**
     * 游戏规则
     */
    private GameRule gameRule;

    /**
     * 房主的id
     */
    private String masterUuId;

    /**
     * 房间密码
     */
    private String password;

    /**
     * 游戏名称
     */
    private String gameName;

}


