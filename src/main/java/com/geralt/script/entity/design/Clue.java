package com.geralt.script.entity.design;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author hewenchao
 * @Date 2022/1/29 9:05
 * @Description 线索
 */
@Setter
@Getter
public class Clue {

    private int id;

    private int scriptId;

    private String groupName;

    private int scene = 1;

    private String content;

}
