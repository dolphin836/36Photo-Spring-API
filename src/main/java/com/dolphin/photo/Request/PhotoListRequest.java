package com.dolphin.photo.Request;

import com.dolphin.photo.Constant.CommonConstant;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author whb
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PhotoListRequest {
    /**
     * 第几页，默认值：1
     */
    @Min(value = 1, message = "page 不能小于 1")
    private Integer page = CommonConstant.FIRST_PAGE_NUMBER;

    /**
     * 每页的数量，默认值：20
     */
    @Min(value = 1, message = "count 不能小于 1")
    @Max(value = 100, message = "count 不能大于 100")
    private Integer count = CommonConstant.PRE_PAGE_COUNT;
}
