package com.dolphin.photo.Exception;

/**
 * @author whb
 */
public interface ExceptionCode {
    /**
     * 获取状态码
     * @return code
     */
    String getCode ();

    /**
     * 获取提示消息
     * @return message
     */
    String getMessage ();
}
