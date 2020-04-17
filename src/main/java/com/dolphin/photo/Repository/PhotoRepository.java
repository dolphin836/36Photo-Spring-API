package com.dolphin.photo.Repository;

import com.dolphin.photo.Entity.Photo;
import org.springframework.data.repository.Repository;

import java.util.List;

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
}
