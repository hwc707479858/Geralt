package com.geralt.script.entity.design;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author hewenchao
 * @Date 2022/1/29 9:02
 * @Description 剧本
 */
@Setter
@Getter
public class Script {

    private int id;

    private String name;

    private String instruction;

    private Date createTime;

    private Date updateTime;

    private boolean isSubmit;

}
