package com.geralt.script.entity.design;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author hewenchao
 * @Date 2022/1/29 9:06
 * @Description 角色
 */
@Setter
@Getter
public class Role {

    private int id;

    private String name;

    private String instruction;

    private String script;

    private String headImage;

    private int scriptId;

}
