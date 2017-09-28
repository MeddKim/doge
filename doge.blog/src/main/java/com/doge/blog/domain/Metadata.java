package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Metadata implements Serializable {
    private Long id;

    private String metaKey;

    private String objectType;

    private Long objectId;

    private String metaValue;

    private static final long serialVersionUID = 1L;

}