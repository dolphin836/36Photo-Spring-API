package com.dolphin.photo.Service.Impl;

import com.dolphin.photo.Entity.Photo;
import com.dolphin.photo.Exception.Common.BusinessException;
import com.dolphin.photo.Exception.PhotoException;
import com.dolphin.photo.Repository.PhotoRepository;
import com.dolphin.photo.Repository.PhotoSimpleRepository;
import com.dolphin.photo.Service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PhotoSimpleRepository photoSimpleRepository;

    @Override
    public Photo getPhoto(Long photoId) {
        Optional<Photo> photo = photoSimpleRepository.findById(photoId);

        if (photo.isPresent()) {
            return photo.get();
        }

        throw new BusinessException(PhotoException.ExceptionCode.PHOTO_NOT_EXIST);
    }

    @Override
    public List<Photo> getPhotoList() {
        List<Photo> photoList = photoRepository.findByCategoryCodeOrderByIdDesc("world");

        for (Photo photo : photoList) {
            log.info("Photo Id: {}", photo.getId());
        }

        long total = photoSimpleRepository.count();

        log.info("Photo Total: {}", total);

        return photoList;
    }
}
