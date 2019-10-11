package com.ada.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ada
 * @ClassName :BaseException
 * @date 2019/10/11 22:24
 * @Description:
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
    private int status = 200;

    public BaseException() {
    }

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
