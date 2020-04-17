package com.dolphin.photo.Constant;

/**
 * @author whb
 */
public class PhotoConstant {
    /**
     * 公开
     */
    public static final Byte IS_PUBLIC = 1;

    /**
     * 不公开
     */
    public static final Byte IS_NOT_PUBLIC = 0;

    /**
     * 已上传到 OSS
     */
    public static final Byte IS_OSS = 1;

    /**
     * 未上传到 OSS
     */
    public static final Byte IS_NOT_OSS = 0;

    /**
     * 照片存储 OSS Bucket 名称
     */
    public static final String OSS_BUCKET_NAME = "36photo";

    /**
     * 照片授权访问的有效时间：单位秒
     */
    public static final Integer OSS_URL_EXPIRATION = 3600;
}
