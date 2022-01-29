package com.geralt.script.dto.game;

import com.geralt.script.entity.design.Clue;
import com.geralt.script.entity.design.Role;
import com.geralt.script.entity.design.Script;

import java.util.*;

/**
 * @Author hewenchao
 * @Date 2022/1/29 11:25
 * @Description
 */
public class Game {

    private String id;

    private String name;

    private Script script;

    private List<Clue> clues = new ArrayList<>();

    private int scene;

    private Map<String, Role> userRoleMap = new HashMap<>();

    private Date createTime;

    //0准备中 1开始游戏 2游戏结束
    private int status = 0;

    private int maxUserCount;

    private Set<String> users = new LinkedHashSet<>();

    private List<Role> roles = new ArrayList<>();

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

    public List<Clue> getClues() {
        return clues;
    }

    public void setClues(List<Clue> clues) {
        this.clues = clues;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public Map<String, Role> getUserRoleMap() {
        return userRoleMap;
    }

    public void setUserRoleMap(Map<String, Role> userRoleMap) {
        this.userRoleMap = userRoleMap;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
