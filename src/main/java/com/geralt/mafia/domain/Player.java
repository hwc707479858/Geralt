package com.geralt.mafia.domain;

import com.geralt.mafia.domain.part.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * 玩家
 */
@Setter
@Getter
public class Player {
    /**
     * 号码
     */
    private int number;

    /**
     * 角色名称
     */
    private String userName;

    /**
     * 是否存活
     */
    private boolean isAlive;

    /**
     * 玩家所扮演的角色
     */
    private Role role;

    /**
     * 警长竞选投票
     */
    void voteForSheriff() {

    }

    /**
     * 放逐公投
     */
    void voteForDie() {

    }

    /**
     * 遗言
     */
    void lastWords() {

    }


}
