package com.dolphin.photo.Service.Impl;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Exception.Common.BusinessException;
import com.dolphin.photo.Exception.PhotoException;
import com.dolphin.photo.Repository.PhotoRepository;
import com.dolphin.photo.Request.PhotoHashRequest;
import com.dolphin.photo.Request.PhotoListRequest;
import com.dolphin.photo.Response.PhotoListResponse;
import com.dolphin.photo.Response.PhotoResponse;
import com.dolphin.photo.Service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author whb
 */
@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public PhotoResponse getPhoto(PhotoHashRequest photoHashRequest) {
        Optional<Photo> photo = photoRepository.findPhotoByHash(photoHashRequest.getHash());

        if (photo.isPresent()) {
            PhotoResponse photoResponse = new PhotoResponse();

            BeanUtils.copyProperties(photo, photoResponse);

            return photoResponse;
        }

        throw new BusinessException(PhotoException.ExceptionCode.PHOTO_NOT_EXIST);
    }

    @Override
    public PhotoListResponse getPhotoList(PhotoListRequest photoListRequest) {
        // 每页的数量
        Integer count = photoListRequest.getCount();
        // 查询记录
        List<Photo> photoList = photoRepository.findByCategoryCodeOrderByIdDesc("world");

        List<PhotoResponse> photoResponseList = new ArrayList<>();
        // 循环处理每条记录
        for (Photo photo : photoList) {
            PhotoResponse photoResponse = new PhotoResponse();
            BeanUtils.copyProperties(photo, photoResponse);
            photoResponseList.add(photoResponse);
        }
        // 查询总数
        long total = photoRepository.count();
        // 设置 Response
        PhotoListResponse photoListResponse = new PhotoListResponse();
        photoListResponse.setPhotoList(photoResponseList);
        photoListResponse.setCount(count);
        photoListResponse.setTotal((int) total);

        return photoListResponse;
    }
}
