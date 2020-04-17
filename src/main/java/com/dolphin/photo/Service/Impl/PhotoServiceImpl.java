package com.dolphin.photo.Service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.dolphin.photo.Constant.PhotoConstant;
import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Exception.Common.BusinessException;
import com.dolphin.photo.Exception.PhotoException;
import com.dolphin.photo.Repository.PhotoRepository;
import com.dolphin.photo.Request.PhotoHashRequest;
import com.dolphin.photo.Request.PhotoListRequest;
import com.dolphin.photo.Response.PhotoListResponse;
import com.dolphin.photo.Response.PhotoResponse;
import com.dolphin.photo.Response.PhotoSimpleResponse;
import com.dolphin.photo.Service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private OSS ossClient;

    @Override
    public PhotoResponse getPhoto(PhotoHashRequest photoHashRequest) {
        Optional<Photo> photo = photoRepository.findPhotoByHash(photoHashRequest.getHash());

        if (photo.isPresent()) {
            PhotoResponse photoResponse = new PhotoResponse();

            BeanUtils.copyProperties(photo.get(), photoResponse);
            // 获取 OSS 访问地址
            String ossFile = photo.get().getPath();
            // 实例化 OSS 实体对应
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(PhotoConstant.OSS_BUCKET_NAME, ossFile);
            // 设置有效时间
            Date ossUrlExpiration = new Date(System.currentTimeMillis() + PhotoConstant.OSS_URL_EXPIRATION * 1000);
            generatePresignedUrlRequest.setExpiration(ossUrlExpiration);
            // 生成可访问的 URL
            URL ossFileUrl = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            // 设置 Response
            photoResponse.setPath(ossFileUrl.toString());

            return photoResponse;
        }

        throw new BusinessException(PhotoException.ExceptionCode.PHOTO_NOT_EXIST);
    }

    @Override
    public PhotoListResponse getPhotoList(PhotoListRequest photoListRequest) {
        // 第几页
        Integer page  = photoListRequest.getPage();
        // 每页的数量
        Integer count = photoListRequest.getCount();
        // 查询记录
        Page<Photo> photoList = photoRepository.findByIsPublicAndIsOssOrderByIdDesc(PhotoConstant.IS_NOT_PUBLIC, PhotoConstant.IS_OSS, PageRequest.of(page - 1, count));

        List<PhotoSimpleResponse> photoSimpleResponseList = new ArrayList<>();
        // 循环处理每条记录
        for (Photo photo : photoList) {
            // 获取 OSS 访问地址
            String ossFile = photo.getPath();
            // 实例化 OSS 实体对应
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(PhotoConstant.OSS_BUCKET_NAME, ossFile);
            // 设置有效时间
            Date ossUrlExpiration = new Date(System.currentTimeMillis() + PhotoConstant.OSS_URL_EXPIRATION * 1000);
            generatePresignedUrlRequest.setExpiration(ossUrlExpiration);
            // 设置图片处理方式：缩放
            String ossPhotoResizeStyle = "image/resize,m_lfit,w_560";
            generatePresignedUrlRequest.setProcess(ossPhotoResizeStyle);
            // 生成可访问的 URL
            URL ossFileUrl = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            // 设置 Response
            PhotoSimpleResponse photoSimpleResponse = new PhotoSimpleResponse();
            photoSimpleResponse.setHash(photo.getHash());
            photoSimpleResponse.setOssUrl(ossFileUrl.toString());

            photoSimpleResponseList.add(photoSimpleResponse);
        }
        // 关闭 OSS
        ossClient.shutdown();
        // 查询总数
        long total = photoRepository.count();
        // 设置 Response
        PhotoListResponse photoListResponse = new PhotoListResponse();
        photoListResponse.setPhotoList(photoSimpleResponseList);
        photoListResponse.setCount(count);
        photoListResponse.setTotal((int) total);

        return photoListResponse;
    }
}
