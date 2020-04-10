package com.dolphin.photo.Repository;

import com.dolphin.photo.Entity.Photo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author whb
 */
public interface PhotoRepository extends CrudRepository<Photo, Long> {
    /**
     * 查询单条记录
     * @param photoId 照片 Id
     * @return Photo
     */
    Photo getPhotoById (Long photoId);

    /**
     * 查询单条记录
     * @param hash 名称
     * @return Photo
     */
    Photo getPhotoByHash (String hash);
}
