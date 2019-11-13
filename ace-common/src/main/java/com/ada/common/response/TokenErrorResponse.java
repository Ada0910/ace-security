package com.ada.common.response;


import com.ada.common.constant.RestCodeConstant;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstant.TOKEN_ERROR_CODE, message);
    }
}
