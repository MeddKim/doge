package com.auth.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UUIDUtils {

    private UUIDUtils() {
        throw new UnsupportedOperationException();
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    // change implementation if the default can not fulfill requirements
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String enquiryBid(String code) {
        return code + LocalDateTime.now().format(formatter);
    }

}

