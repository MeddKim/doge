package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Attachment implements Serializable {

    private Long id;

    private Long userId;

    private Long contentId;

    private String path;

    private String mimeType;

    private String suffix;

    private String type;

    private String flag;

    private BigDecimal lat;

    private BigDecimal lng;

    private Integer orderNumber;

    private Date created;

    private String title;

    private static final long serialVersionUID = 1L;


}