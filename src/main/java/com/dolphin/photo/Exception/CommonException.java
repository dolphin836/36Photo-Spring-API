package com.dolphin.photo.Exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 功能异常类
 * @author whb
 */
public interface CommonException {
    /**
     * 整个应用公共的异常码
     */
    String COMMON_CODE = "10";

    enum ExceptionCode implements com.dolphin.photo.Exception.ExceptionCode {
        /**
         * 记录不存在
         */
        RECORD_NOT_EXIST( COMMON_CODE + "00", "记录不存在");

        /**
         * 状态码
         */
        @Getter
        @Setter
        private String code;

        /**
         * 提示消息
         */
        @Getter
        @Setter
        private String message;

        ExceptionCode (String code, String message) {
            this.code    = code;
            this.message = message;
        }
    }
}
