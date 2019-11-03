package com.ada.common.handler;


import com.ada.common.constant.CommonConstant;
import com.ada.common.exception.BaseException;
import com.ada.common.exception.auth.ClientTokenException;
import com.ada.common.exception.auth.UserInvalidException;
import com.ada.common.exception.auth.UserTokenException;
import com.ada.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName:GlobalExceptionHandler
 * @author: Ada
 * @date 2019/10/23 15:22
 * @Description: 全局异常处理类
 */

@ControllerAdvice("com.ada")
@ResponseBody
public class GlobalExceptionHandler {
    //日志类
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ClientTokenException.class)
    public BaseResponse clientTokenExceptionHandler(HttpServletResponse response, ClientTokenException ex) {
        response.setStatus(403);
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(UserTokenException.class)
    public BaseResponse userTokenExceptionHandler(HttpServletResponse response, UserTokenException ex) {
        response.setStatus(200);
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(UserInvalidException.class)
    public BaseResponse userInvalidExceptionHandler(HttpServletResponse response, UserInvalidException ex) {
        response.setStatus(200);
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        logger.error(ex.getMessage(), ex);
        response.setStatus(500);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
        response.setStatus(500);
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(CommonConstant.EX_OTHER_CODE, ex.getMessage());
    }
}
