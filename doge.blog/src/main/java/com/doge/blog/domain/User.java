package com.doge.blog.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;

    private String username;

    private String nickname;

    private String realname;

    private String password;

    private String salt;

    private String email;

    private String emailStatus;

    private String mobile;

    private String mobileStatus;

    private String telephone;

    private BigDecimal amount;

    private String gender;

    private String role;

    private String signature;

    private Integer contentCount;

    private Integer commentCount;

    private String qq;

    private String wechat;

    private String weibo;

    private String facebook;

    private String linkedin;

    private Date birthday;

    private String company;

    private String occupation;

    private String address;

    private String zipcode;

    private String site;

    private String graduateschool;

    private String education;

    private String avatar;

    private String idcardtype;

    private String idcard;

    private String status;

    private Date created;

    private String createSource;

    private Date logged;

    private Date activated;

    private static final long serialVersionUID = 1L;

}