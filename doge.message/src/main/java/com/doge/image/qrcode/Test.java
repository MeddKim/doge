package com.doge.image.qrcode;

import java.io.File;
import java.io.InputStream;

public class Test {
    private static void encode() {
        QRCodeUtils creator = new QRCodeUtils();
        QRCodeInfo info = new QRCodeInfo();
        info.setWidth(400);
        info.setHeight(400);
        info.setFontSize(24);
        info.setContents("<a href='http://www.sohu.com'>人生就是拼搏</a>");
        //info.setContents("http://www.sohu.com");
        info.setContents("天涯明月刀");
        info.setLogoFile(new File("D:/VirtualBox/timg.jpg"));
        info.setDesc("张三李四");
        //info.setLogoDesc("一叶浮萍归大海，adsasfbhtjg人生何处不相逢");
        //info.setLogoDesc("一叶浮萍");
        creator.createCodeImage(info, "D:/VirtualBox/dest." + info.getFormat());
    }

    static public void decode(InputStream input){
        QRCodeDecoder decoder = new QRCodeDecoder();
        String result = decoder.decode(input);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        encode();
        //decode(new FileInputStream(new File("D:/2Dcode/dest.gif")));
    }
}
