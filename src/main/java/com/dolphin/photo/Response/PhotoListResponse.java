package com.dolphin.photo.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

/**
 * @author whb
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PhotoListResponse {
    /**
     * 照片列表
     */
    private List<PhotoResponse> photoList;

    /**
     * 当前页数量
     */
    private Integer count;

    /**
     * 照片总数
     */
    private Integer total;
}
