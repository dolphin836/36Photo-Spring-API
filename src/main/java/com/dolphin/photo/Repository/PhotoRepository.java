package com.dolphin.photo.Repository;

import com.dolphin.photo.Entity.Photo;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author whb
 */
public interface PhotoRepository extends Repository<Photo, Long> {
    /**
     * 根据分类批量查询照片记录
     * @param categoryCode 分类编码
     * @return List<Photo>
     */
    List<Photo> findByCategoryCodeOrderByIdDesc (String categoryCode);

    /**
     * 查询照片记录总数
     * @return long
     */
    long count ();

    /**
     * 根据 Hash 查询单条照片记录
     * @param hash 照片 Hash 值
     * @return Optional<Photo>
     */
    Optional<Photo> findPhotoByHash (String hash);
}
