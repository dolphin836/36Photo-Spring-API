package com.dolphin.photo.Exception;

import com.dolphin.photo.Exception.Common.ExceptionCodeDefine;
import lombok.Getter;
import lombok.Setter;

/**
 * @author whb
 */
public interface PhotoException {
    /**
     * 整个应用公共的异常码
     */
    String COMMON_CODE = "11";

    enum ExceptionCode implements ExceptionCodeDefine {
        /**
         * 图片不存在
         */
        PHOTO_NOT_EXIST( COMMON_CODE + "00", "图片不存在");

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
