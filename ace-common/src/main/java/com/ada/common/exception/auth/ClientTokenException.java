package com.ada.common.exception.auth;

import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;

/**
 * @ClassName:ClientTokenException
 * @author: Ada
 * @date 2019/10/23 15:27
 * @Description:
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {

        super(message, CommonConstant.EX_CLIENT_INVALID_CODE);
    }
}
