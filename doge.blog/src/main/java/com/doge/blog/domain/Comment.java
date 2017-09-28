package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Comment implements Serializable {
    private Long id;

    private Long parentId;

    private Long contentId;

    private String contentModule;

    private Integer commentCount;

    private Integer orderNumber;

    private Long userId;

    private String ip;

    private String author;

    private String type;

    private String text;

    private String agent;

    private Date created;

    private String slug;

    private String email;

    private String status;

    private Integer voteUp;

    private Integer voteDown;

    private String flag;

    private BigDecimal lat;

    private BigDecimal lng;

    private static final long serialVersionUID = 1L;


}