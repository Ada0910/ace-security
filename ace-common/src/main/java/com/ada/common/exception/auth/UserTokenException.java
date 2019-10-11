package com.ada.common.exception.auth;

import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;

/**
 * @author Ada
 * @ClassName :UserTokenException
 * @date 2019/10/11 22:26
 * @Description:
 */
public class UserTokenException extends BaseException {

    public UserTokenException(String message) {
        super(message, CommonConstant.EX_USER_INVALID_CODE);
    }
}
