package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Taxonomy implements Serializable {
    private Long id;

    private String title;

    private String slug;

    private String type;

    private String icon;

    private String contentModule;

    private Integer contentCount;

    private Integer orderNumber;

    private Long parentId;

    private Long objectId;

    private String flag;

    private BigDecimal lat;

    private BigDecimal lng;

    private String metaKeywords;

    private String metaDescription;

    private Date created;

    private String text;

    private static final long serialVersionUID = 1L;

}