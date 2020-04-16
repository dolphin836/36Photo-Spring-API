package com.dolphin.photo.Exception.Common;

/**
 * @author whb
 */
public interface ExceptionCodeDefine {
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
