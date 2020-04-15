package com.dolphin.photo.Exception;

import lombok.Getter;

/**
 * @author whb
 */
public class BusinessException extends RuntimeException {
    /**
     * 状态码
     */
    @Getter
    private final String code;

    /**
     * 提示消息
     */
    @Getter
    private final String message;

    /**
     * 整个应用公共的异常码
     */
    private static final String APP_EXCEPTION_CODE = "10";

    public BusinessException (ExceptionCodeDefine exception) {
        super(exception.getMessage());

        this.code    = APP_EXCEPTION_CODE + exception.getCode();
        this.message = exception.getMessage();
    }
}
