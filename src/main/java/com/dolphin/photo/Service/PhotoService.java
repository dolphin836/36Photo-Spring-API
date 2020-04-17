package com.dolphin.photo.Service;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Request.PhotoHashRequest;
import com.dolphin.photo.Request.PhotoListRequest;
import com.dolphin.photo.Response.PhotoListResponse;
import com.dolphin.photo.Response.PhotoResponse;

/**
 * @author whb
 */
public interface PhotoService {
    /**
     * 根据照片 Hash 查询单个图片信息
     * @param  photoHashRequest 照片 Hash 值
     * @return PhotoResponse
     */
    PhotoResponse getPhoto (PhotoHashRequest photoHashRequest);

    /**
     * 批量查询照片记录 - 分页
     * @param photoListRequest 检索条件
     * @return PhotoListResponse
     */
    PhotoListResponse getPhotoList (PhotoListRequest photoListRequest);
}
