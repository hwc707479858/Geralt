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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isSubmit() {
        return isSubmit;
    }

    public void setSubmit(boolean submit) {
        isSubmit = submit;
    }
}
