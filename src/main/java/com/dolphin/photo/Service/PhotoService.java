package com.dolphin.photo.Service;

import com.dolphin.photo.Entity.Photo;

/**
 * @author whb
 */
public interface PhotoService {
    /**
     * 根据照片 Id 查询单个图片信息
     * @param  photoId 照片 Id
     * @return Photo
     */
    Photo getPhoto (Long photoId);
}
