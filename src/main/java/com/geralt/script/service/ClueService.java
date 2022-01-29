package com.geralt.script.service;

import com.geralt.script.entity.design.Clue;

import java.util.List;

/**
 * @Author hewenchao
 * @Date 2022/1/29 10:44
 * @Description
 */
public interface ClueService {

    void save(Clue clue);

    void delete(int clueId);

    Clue getById(int clueId);

    List<Clue> listByScriptId(int scriptId);
}
