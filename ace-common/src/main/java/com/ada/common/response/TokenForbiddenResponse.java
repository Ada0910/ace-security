package com.ada.common.response;


import com.ada.common.constant.RestCodeConstant;

public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstant.TOKEN_FORBIDDEN_CODE, message);
    }
}
