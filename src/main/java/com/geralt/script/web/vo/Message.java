package com.geralt.script.web.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author hewenchao
 * @Date 2022/1/29 13:23
 * @Description
 */
@Setter
@Getter
public class Message {

    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
