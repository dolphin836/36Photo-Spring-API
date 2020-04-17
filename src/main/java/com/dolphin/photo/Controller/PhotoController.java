package com.dolphin.photo.Controller;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Request.PhotoHashRequest;
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

    @PostMapping("hash")
    public Response<PhotoResponse> getPhoto (@RequestBody @Validated PhotoHashRequest photoHashRequest) {
        return Response.success(photoService.getPhoto(photoHashRequest));
    }

    @PostMapping("list")
    public Response<PhotoListResponse> getPhotoList (@RequestBody @Validated PhotoListRequest photoListRequest) {
        return Response.success(photoService.getPhotoList(photoListRequest));
    }
}
