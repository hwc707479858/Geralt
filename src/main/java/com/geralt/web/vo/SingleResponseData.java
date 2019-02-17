package com.geralt.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleResponseData extends ResponseData {

    private Object data;

    public SingleResponseData(int code, Object data) {
        this.code = code;
        this.data = data;
    }


}
