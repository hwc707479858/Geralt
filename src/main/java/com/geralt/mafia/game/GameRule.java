package com.geralt.mafia.game;

import com.geralt.mafia.config.StaticValue;
import com.geralt.mafia.domain.part.Role;
import com.geralt.mafia.domain.part.Seer;
import com.geralt.mafia.domain.part.Villager;
import com.geralt.mafia.domain.part.Werewolf;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏规则判定
 */
@Setter
@Getter
public class GameRule {


    private static final int DEFAULT_WOLF_NUM = 3;

    private static final String[] DEFAULT_GOD = {"Seer", "Witch", "Hunter"};

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
    private boolean idoitMastDie = false;


    private GameRule() {}

    /**
     * 设置游戏初始化规则
     * @param totalNum
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static GameRule defaultGameRule(int totalNum) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Role> roleList = new ArrayList<Role>(totalNum);
        GameRule gameRule = new GameRule();
        gameRule.setGodNum(DEFAULT_GOD.length);
        gameRule.setWolfNum(DEFAULT_WOLF_NUM);
        gameRule.setVilleagerNum(totalNum - gameRule.getGodNum() - gameRule.getWolfNum());
        for (int i = 1; i <= gameRule.getWolfNum(); i++) {
            roleList.add(new Werewolf());
        }
        for (int i = 1; i <= gameRule.getVilleagerNum(); i++) {
            roleList.add(new Villager());
        }
        roleList.add(new Seer());
        for (int i = 0; i < gameRule.getGodNum(); i++) {
            roleList.add((Role) Class.forName(StaticValue.MAFIA_ROLE_PAKAGE_PATH + "." + DEFAULT_GOD[i]).newInstance());
        }
        gameRule.setRoleList(roleList);
        gameRule.setIdoitMastDie(false);
        return gameRule;
    }

    /**
     * 游戏规则设置
     * @param totalNum
     * @param wolfNum
     * @param gods
     */
    public void setGameRule(int totalNum, int wolfNum, String[] gods, boolean idoitMastDie) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Role> roleList = new ArrayList<Role>(totalNum);
        setGodNum(gods.length);
        setWolfNum(wolfNum);
        setVilleagerNum(totalNum - getGodNum() - getWolfNum());
        for (int i = 1; i <= getWolfNum(); i++) {
            roleList.add(new Werewolf());
        }
        for (int i = 1; i <= getVilleagerNum(); i++) {
            roleList.add(new Villager());
        }
        for (int i = 0; i < gods.length; i ++) {
            roleList.add((Role) Class.forName(StaticValue.MAFIA_ROLE_PAKAGE_PATH + "." + DEFAULT_GOD[i]).newInstance());
        }
        setRoleList(roleList);
        setIdoitMastDie(idoitMastDie);
    }


    public int getTotalNum() {
        return getWolfNum() + getGodNum() + getVilleagerNum();
    }

}
