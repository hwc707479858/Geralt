package com.geralt.script.service;

import com.geralt.script.entity.design.Role;

import java.util.List;

/**
 * @Author hewenchao
 * @Date 2022/1/29 10:43
 * @Description
 */
public interface RoleService {

    void save(Role role);

    void delete(int roleId);

    Role getById(int roleId);

    List<Role> listByScriptId(int scriptId);
}
