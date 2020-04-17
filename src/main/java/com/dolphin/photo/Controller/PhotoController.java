package com.dolphin.photo.Controller;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Request.PhotoIdRequest;
import com.dolphin.photo.Request.PhotoListRequest;
import com.dolphin.photo.Response.PhotoListResponse;
import com.dolphin.photo.Response.PhotoResponse;
import com.dolphin.photo.Response.Response;
import com.dolphin.photo.Service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author whb
 */
@RestController
@RequestMapping("photo")
@Slf4j
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("one")
    public Response<PhotoResponse> getPhoto (@RequestBody @Validated PhotoIdRequest photoIdRequest) {
        Long photoId = photoIdRequest.getPhotoId();

        Photo photo  = photoService.getPhoto(photoId);

        PhotoResponse photoResponse = new PhotoResponse();

        BeanUtils.copyProperties(photo, photoResponse);

        return Response.success(photoResponse);
    }

    @PostMapping("list")
    public Response<PhotoListResponse> getPhotoList (@RequestBody @Validated PhotoListRequest photoListRequest) {
        log.info("Page: {}", photoListRequest.getPage());
        log.info("Count: {}", photoListRequest.getCount());

        photoService.getPhotoList();

        PhotoListResponse photoListResponse = new PhotoListResponse();
        photoListResponse.setCount(0);
        photoListResponse.setTotal(25);

        return Response.success(photoListResponse);
    }
}
