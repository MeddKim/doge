package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Content implements Serializable {
    private Long id;

    private String title;

    private String text;

    private String summary;

    private String linkTo;

    private Boolean markdownEnable;

    private String thumbnail;

    private String module;

    private String style;

    private Long userId;

    private String author;

    private String userEmail;

    private String userIp;

    private String userAgent;

    private Long parentId;

    private Long objectId;

    private Integer orderNumber;

    private String status;

    private Integer voteUp;

    private Integer voteDown;

    private Integer rate;

    private Integer rateCount;

    private BigDecimal price;

    private String commentStatus;

    private Integer commentCount;

    private Date commentTime;

    private Integer viewCount;

    private Date created;

    private Date modified;

    private String slug;

    private String flag;

    private BigDecimal lng;

    private BigDecimal lat;

    private String metaKeywords;

    private String metaDescription;

    private String remarks;

    private List<Mapping> mappings;

    private static final long serialVersionUID = 1L;


}