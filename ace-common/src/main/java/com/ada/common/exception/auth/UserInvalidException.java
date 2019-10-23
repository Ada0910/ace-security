package com.ada.common.exception.auth;

import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;

/**
 * @ClassName:UserInvalidException
 * @author: Ada
 * @date 2019/10/23 15:28
 * @Description:
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstant.EX_USER_PASS_INVALID_CODE);
    }
}