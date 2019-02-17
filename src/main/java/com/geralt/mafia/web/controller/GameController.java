package com.geralt.mafia.web.controller;

import com.geralt.web.vo.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建游戏相关
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @RequestMapping("/create")
    public ResponseData createGame() {
        return ResponseData.newSingleInstance("创建成功");
    }

}
