package com.dolphin.photo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author whb
 */
@Data
@Entity
@Table(name="picture")
public class Photo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

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

    private Byte isPublic;

    private Byte isOss;

    private String categoryCode;

    private Date gmtCreate;

    private Date gmtModified;
}
