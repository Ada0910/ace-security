package com.ada.common.exception.auth;

import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;

/**
 * @ClassName:ClientForbiddenException
 * @author: Ada
 * @date 2019/10/23 16:47
 * @Description:
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstant.EX_CLIENT_FORBIDDEN_CODE);
    }

}
