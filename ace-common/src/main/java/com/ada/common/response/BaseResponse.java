package com.ada.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ada
 * @ClassName :BaseResponse
 * @date 2019/10/4 17:08
 * @Description:响应信息基础类
 */
@Getter
@Setter
public class BaseResponse {
    private int status = 200;
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse() {
    }

}
