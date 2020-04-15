package com.dolphin.photo.Controller;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Request.PhotoIdRequest;
import com.dolphin.photo.Response.PhotoResponse;
import com.dolphin.photo.Response.Response;
import com.dolphin.photo.Service.PhotoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author whb
 */
@RestController
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("photo")
    public Response<PhotoResponse> getPhoto (@RequestBody @Validated PhotoIdRequest request) {
        Long photoId = request.getPhotoId();

        Photo photo  = photoService.getPhoto(photoId);

        PhotoResponse photoResponse = new PhotoResponse();

        BeanUtils.copyProperties(photo, photoResponse);

        return Response.success(photoResponse);
    }
}
