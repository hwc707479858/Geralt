package com.geralt.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponseData extends ResponseData {

    private List list;

    public ListResponseData(int code, List list) {
        this.code = code;
        this.list = list;
    }
}
