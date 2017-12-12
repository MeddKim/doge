package com.doge.image.qrcode;

import lombok.Data;

import java.io.File;


@Data
public class QRCodeInfo {

    private String contents;
    private int width = 400;
    private int height = 400;
    private String format = "gif";
    private String character_set = "utf-8";
    private int fontSize = 12;
    private File logoFile;
    private float logoRatio = 0.20f;
    private String desc;
    private int whiteWidth;//白边的宽度
    private int[] bottomStart;//二维码最下边的开始坐标
    private int[] bottomEnd;//二维码最下边的结束坐标




}
