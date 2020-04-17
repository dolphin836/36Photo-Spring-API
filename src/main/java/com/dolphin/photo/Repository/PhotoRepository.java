package com.dolphin.photo.Repository;

import com.dolphin.photo.Entity.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author whb
 */
public interface PhotoRepository extends Repository<Photo, Long> {
    /**
     * 根据分类批量查询照片记录
     * @param categoryCode 分类编码
     * @param page 分页信息
     * @return List<Photo>
     */
    Page<Photo> findByCategoryCodeOrderByIdDesc (String categoryCode, Pageable page);

    /**
     * 根据分类批量查询照片记录
     * @param isPublic 是否公开
     * @param isOss 是否已上传到 OSS
     * @param page 分页信息
     * @return List<Photo>
     */
    Page<Photo> findByIsPublicAndIsOssOrderByIdDesc (Byte isPublic, Byte isOss, Pageable page);

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
