package com.geralt.web.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResponseData {

    protected int code;

    protected String message;

    public static final int SUCCESS_CODE = 1;

    public static ResponseData newErrorInstance(int errorCode, String message) {
        ResponseData data = new ResponseData();
        data.code = errorCode;
        data.message = message;
        return data;

    }

    public static ListResponseData newListInstance(List list) {
        return new ListResponseData(SUCCESS_CODE, list);
    }

    public static SingleResponseData newSingleInstance(Object data) {
        return new SingleResponseData(SUCCESS_CODE, data);
    }

}
