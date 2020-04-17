package com.dolphin.photo.Repository;

import com.dolphin.photo.Entity.Photo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author whb
 */
public interface PhotoSimpleRepository extends CrudRepository<Photo, Long> {

}
