package com.dolphin.photo.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author whb
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PhotoIdRequest {
    @NotNull(message = "photo_id 不能为空")
    @Min(value = 1, message = "photo_id 不能小于 1")
    private Long photoId;
}
