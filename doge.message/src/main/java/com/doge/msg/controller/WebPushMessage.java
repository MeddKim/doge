package com.doge.msg.controller;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
public class WebPushMessage implements Serializable {
    private String accountId;
    private PushCode pushCode;
    private String message;
    private AppClientType appClientType;
    private Map<String, Object> paramsMap;

    public  enum  PushCode{
        BASE(0),
        OPEN_BUYER_ENQUIRY_LIST_PART(10011),
        OPEN_BUYER_ENQUIRY_DETAIL_PART(10012),
        OPEN_BUYER_ORDER_LIST(10040);

        private int code;

        private PushCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    public enum AppClientType {
        BUYER,
        VENDOR;

        private AppClientType() {
        }
    }
}


