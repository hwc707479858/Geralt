package com.geralt.script.service;

import com.geralt.script.entity.design.Script;

/**
 * @Author hewenchao
 * @Date 2022/1/29 10:41
 * @Description
 */
public interface ScriptService {

    void save(Script script);

    void delete(int scriptId);

    Script getById(int scriptId);

    void submit(int scriptId);
}
