package com.dolphin.photo.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * @author whb
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PhotoResponse implements Serializable {
    private String hash;

    private String uuid;

    private String path;

    private Integer width;

    private Integer height;

    private Integer size;

    private Integer browse;

    private Integer download;

    private Integer collect;

    private Integer like;

    private String categoryCode;
}
