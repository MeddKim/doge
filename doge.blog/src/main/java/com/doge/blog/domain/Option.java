package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Option implements Serializable {
    private Long id;

    private String optionKey;

    private String optionValue;

    private static final long serialVersionUID = 1L;

}