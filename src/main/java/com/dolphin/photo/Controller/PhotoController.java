package com.dolphin.photo.Controller;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Repository.PhotoRepository;
import com.dolphin.photo.Request.PhotoIdRequest;
import com.dolphin.photo.Response.PhotoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author whb
 */
@RestController
public class PhotoController {
    // private static final String template = "Hello, %s!";
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping("photo")
    public PhotoResponse getPhoto (@RequestBody PhotoIdRequest request) {
        Long photoId = request.getPhotoId();

        Photo photo  = photoRepository.getPhotoById(photoId);

        PhotoResponse photoResponse = new PhotoResponse();

        BeanUtils.copyProperties(photo, photoResponse);

        return photoResponse;
    }
}
