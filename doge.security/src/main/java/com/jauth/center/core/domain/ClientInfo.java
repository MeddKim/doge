package com.jauth.center.core.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Meddkim on 2017/11/26.
 */
@Data
public class ClientInfo implements Serializable {

        private Integer id;

        private String code;

        private String secret;

        private String name;

        private boolean isLocked;

        private String description;

        private Date crtTime;

        private String crtUser;

        private String crtName;

        private String crtHost;

        private Date updTime;

        private String updUser;

        private String updName;

        private String updHost;
}
