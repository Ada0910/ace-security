package com.ada.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ada
 * @ClassName :ObjectRestResponse
 * @date 2019/10/5 10:29
 * @Description:
 */
@Getter
@Setter
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel;

    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
}
