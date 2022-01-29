package com.geralt.script.service.impl;

import com.geralt.script.entity.design.Role;
import com.geralt.script.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author hewenchao
 * @Date 2022/1/29 10:43
 * @Description
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Override
    public void save(Role role) {

    }

    @Override
    public void delete(int roleId) {

    }

    @Override
    public Role getById(int roleId) {
        return null;
    }

    @Override
    public List<Role> listByScriptId(int scriptId) {

        return new LinkedList<>();
    }
}
