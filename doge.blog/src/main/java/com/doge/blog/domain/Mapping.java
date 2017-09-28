package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Mapping implements Serializable {
    private Long id;

    private Long contentId;

    private Long taxonomyId;

    private static final long serialVersionUID = 1L;

}