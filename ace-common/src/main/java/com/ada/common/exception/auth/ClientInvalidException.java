package com.ada.common.exception.auth;

import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;

/**
 * @ClassName:ClientInvalidException
 * @author: Ada
 * @date 2019/10/23 16:45
 * @Description:
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstant.EX_CLIENT_INVALID_CODE);
    }
}