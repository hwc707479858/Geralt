package com.geralt.script.service.impl;

import com.geralt.script.entity.design.Clue;
import com.geralt.script.service.ClueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hewenchao
 * @Date 2022/1/29 10:45
 * @Description
 */
@Service
public class ClueServiceImpl implements ClueService {

    @Override
    public void save(Clue clue) {

    }

    @Override
    public void delete(int clueId) {

    }

    @Override
    public Clue getById(int clueId) {
        return null;
    }

    @Override
    public List<Clue> listByScriptId(int scriptId) {
        return new ArrayList<>();
    }
}
