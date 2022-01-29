package com.geralt.script.web.vo;

import com.geralt.script.dto.game.Game;
import com.geralt.script.entity.design.Script;

import java.util.Date;
import java.util.Set;

/**
 * @Author hewenchao
 * @Date 2022/1/29 15:08
 * @Description
 */
public class SimpleGameVo {

    private String id;

    private String name;

    private Script script;

    private Date createTime;

    private int maxUserCount;

    private Set<String> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getMaxUserCount() {
        return maxUserCount;
    }

    public void setMaxUserCount(int maxUserCount) {
        this.maxUserCount = maxUserCount;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public static SimpleGameVo initByGame(Game game) {
        SimpleGameVo simpleGameVo = new SimpleGameVo();
        simpleGameVo.setCreateTime(game.getCreateTime());
        simpleGameVo.setId(game.getId());
        simpleGameVo.setUsers(game.getUsers());
        simpleGameVo.setName(game.getName());
        simpleGameVo.setMaxUserCount(game.getMaxUserCount());
        return simpleGameVo;
    }
}
