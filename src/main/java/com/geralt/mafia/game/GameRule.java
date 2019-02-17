package com.geralt.mafia.game;

import com.geralt.mafia.domain.part.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 游戏规则判定
 */
@Setter
@Getter
@Builder
public class GameRule {

    /**
     * 狼人的数量
     */
    private int wolfNum;

    /**
     * 村民的数量
     */
    private int villeagerNum;

    /**
     * 神的数量
     */
    private int godNum;

    /**
     * 本局游戏所包含的角色
     */
    private List<Role> roleList;

    /**
     * 白痴双坑规则
     */
    private boolean idoitMastDie;
}
