package com.dolphin.photo.Service.Impl;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Exception.Common.BusinessException;
import com.dolphin.photo.Exception.PhotoException;
import com.dolphin.photo.Repository.PhotoRepository;
import com.dolphin.photo.Service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author whb
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo getPhoto(Long photoId) {
        Photo photo = photoRepository.getPhotoById(photoId);

        if (photo == null) {
            throw new BusinessException(PhotoException.ExceptionCode.PHOTO_NOT_EXIST);
        }

        return photo;
    }
}
