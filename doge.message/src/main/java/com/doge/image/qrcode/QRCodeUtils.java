package com.doge.image.qrcode;

import ch.qos.logback.core.util.FileUtil;
import com.google.common.base.Strings;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.info;

public class QRCodeUtils {

    private static int BLACK = 0x000000;
    private static int WHITE = 0xFFFFFF;

    /**
     * 创建二维码数据部分
     * @param codeInfo
     * @return
     */
    private BufferedImage createQRCode(QRCodeInfo codeInfo){
        String contents = codeInfo.getContents();
        int width = codeInfo.getWidth();
        int height = codeInfo.getHeight();
        Map<EncodeHintType, Object> hint = new HashMap<>();
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hint.put(EncodeHintType.CHARACTER_SET, codeInfo.getCharacter_set());
        hint.put(EncodeHintType.MARGIN, 0);
        MultiFormatWriter writer = new MultiFormatWriter();
        BufferedImage img = null;
        try {
            BitMatrix bm = writer.encode(contents, BarcodeFormat.QR_CODE, width, height, hint);
            int[] locationTopLeft = bm.getTopLeftOnBit();
            int[] locationBottomRight = bm.getBottomRightOnBit();
            codeInfo.setBottomStart(new int[]{locationTopLeft[0], locationBottomRight[1]});
            codeInfo.setBottomEnd(locationBottomRight);
            int w = bm.getWidth();
            int h = bm.getHeight();
            img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            for(int x=0;x<w;x++){
                for(int y=0;y<h;y++){
                    img.setRGB(x, y, bm.get(x, y) ? BLACK : WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return img;
    }
    /**
    public void createQRCode(QRCodeInfo codeInfo, OutputStream output){
        //二维码部分
        BufferedImage bm = createQRCode(codeInfo);
        Graphics g = bm.getGraphics();
        //log存在计算log图片相关数据
        File logoFile = codeInfo.getLogoFile();
        if(null != logoFile && logoFile.exists()){
            try {
                BufferedImage logoImg = ImageIO.read(logoFile);
                //获取logo图大小，根据比例缩放
                int logoWidth = logoImg.getWidth();
                int logoHeight = logoImg.getHeight();
                int width = bm.getWidth();
                int height = bm.getHeight();
                float ratio = codeInfo.getLogoRatio();
                if(ratio>0){
                    logoWidth = logoWidth>width*ratio ? (int)(width*ratio) : logoWidth;
                    logoHeight = logoHeight>height*ratio ? (int)(height*ratio) : logoHeight;
                }
                //在二维码图片中家属Logo图片
                int x = (width-logoWidth)/2;
                int y = (height-logoHeight)/2;
                //绘制log图
                g.drawImage(logoImg, x, y, logoWidth, logoHeight, null);
            }catch (Exception e){

            }

        }
        //标题存在，计算标题相关数据
        if(!Strings.isNullOrEmpty(codeInfo.getTitle())){
            try {
                String title = codeInfo.getTitle();
                //计算白边宽度
                int whiteWidth = codeInfo.getHeight()-codeInfo.getBottomEnd()[1];
                //生成字体
                Font font = new Font("黑体", Font.BOLD, codeInfo.getFontSize());
                int fontHeight = g.getFontMetrics(font).getHeight();
                //文字内容多需要换行并计算相应数据
                int lineNum = 1;
                int currentLineLen = 0;
                for(int i=0;i<title.length();i++){
                    char c = title.charAt(i);
                    int charWidth = g.getFontMetrics(font).charWidth(c);
                    if(currentLineLen + charWidth> bm.getWidth()){
                        lineNum++;
                        currentLineLen = 0;
                        continue;
                    }
                    currentLineLen += charWidth;
                }
                //文字内容高度
                int totalFontHeight = fontHeight*lineNum;   //文字内容高度
                //设置一个文字下边距
                int wordBottomMargin = 10;
                //根据 各部分大小重新设计二维码
                BufferedImage bm1 = new BufferedImage(codeInfo.getWidth(),
                        codeInfo.getWidth()+totalFontHeight+wordBottomMargin-whiteWidth,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g1 = bm1.getGraphics();
                //绘制文字区域
                if(totalFontHeight + wordBottomMargin -whiteWidth > 0){
                    g1.setColor(Color.WHITE);
                    g1.fillRect(0,0,codeInfo.getWidth(),totalFontHeight + wordBottomMargin-whiteWidth);
                }
                g1.setColor(new Color(BLACK));
                g1.setFont(font);
                //绘制原有二维码
                g1.drawImage(bm, 0, totalFontHeight + wordBottomMargin-whiteWidth, null);

                //绘制文字
                int width = codeInfo.getBottomEnd()[0]-codeInfo.getBottomStart()[0];
                currentLineLen = 0;
                int currentLineIndex = 0;
                int baseLo = g.getFontMetrics().getAscent();
                for(int i=0;i<title.length();i++){
                    String c = title.substring(i, i+1);
                    int charWidth = g.getFontMetrics(font).stringWidth(c);
                    if(currentLineLen+charWidth>width){
                        currentLineIndex++;
                        currentLineLen = 0;
                        g1.drawString(c, currentLineLen + whiteWidth, baseLo+fontHeight*(currentLineIndex)+wordBottomMargin);
                        currentLineLen = charWidth;
                        continue;
                    }
                    g1.drawString(c, currentLineLen + whiteWidth, baseLo+fontHeight*(currentLineIndex)+wordBottomMargin);
                    currentLineLen += charWidth;
                }
                g1.dispose();
                bm = bm1;
            }catch (Exception e){

            }

        }

        try{
            ImageIO.write(bm, StringUtils.isEmpty(codeInfo.getFormat()) ? codeInfo.getFormat() : codeInfo.getFormat(), output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }**/
    public void createQRCode(QRCodeInfo codeInfo, OutputStream output){
        //二维码部分
        BufferedImage bm = createQRCode(codeInfo);
        Graphics g = bm.getGraphics();
        //log存在计算log图片相关数据
        File logoFile = codeInfo.getLogoFile();
        if(null != logoFile && logoFile.exists()){
            try {
                BufferedImage logoImg = ImageIO.read(logoFile);
                //获取logo图大小，根据比例缩放
                int logoWidth = logoImg.getWidth();
                int logoHeight = logoImg.getHeight();
                int width = bm.getWidth();
                int height = bm.getHeight();
                float ratio = codeInfo.getLogoRatio();
                if(ratio>0){
                    logoWidth = logoWidth>width*ratio ? (int)(width*ratio) : logoWidth;
                    logoHeight = logoHeight>height*ratio ? (int)(height*ratio) : logoHeight;
                }
                //在二维码图片中家属Logo图片
                int x = (width-logoWidth)/2;
                int y = (height-logoHeight)/2;
                //绘制log图
                g.drawImage(logoImg, x, y, logoWidth, logoHeight, null);
            }catch (Exception e){

            }

        }
        //标题存在，计算标题相关数据
        if(!Strings.isNullOrEmpty(codeInfo.getTitle())){
            try {
                String title = codeInfo.getTitle();
                //计算白边宽度
                int whiteWidth = codeInfo.getHeight()-codeInfo.getBottomEnd()[1];
                //生成字体
                Font font = new Font("黑体", Font.BOLD, codeInfo.getFontSize());
                int fontHeight = g.getFontMetrics(font).getHeight();
                //设置一个文字下边距
                int wordBottomMargin = 10;
                //根据 各部分大小重新设计二维码
                BufferedImage bm1 = new BufferedImage(codeInfo.getWidth(),
                        codeInfo.getWidth()+fontHeight+wordBottomMargin-whiteWidth,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g1 = bm1.getGraphics();

                //绘制文字区域
                g1.setColor(Color.WHITE);
                g1.fillRect(0,0,codeInfo.getWidth(),fontHeight + wordBottomMargin-whiteWidth);
                //绘制原有二维码
                g1.setColor(new Color(BLACK));
                g1.setFont(font);
                g1.drawImage(bm, 0, fontHeight + wordBottomMargin-whiteWidth, null);
                //绘制文字
                int baseLo = g.getFontMetrics().getAscent();
                int titleLen = g.getFontMetrics(font).stringWidth(codeInfo.getTitle());
                int titleX = (codeInfo.getWidth() - titleLen)/2;  //文字居中

                g1.drawString(codeInfo.getTitle(),titleX-baseLo,whiteWidth+wordBottomMargin);

                g1.dispose();
                bm = bm1;
            }catch (Exception e){

            }

        }

        try{
            ImageIO.write(bm, StringUtils.isEmpty(codeInfo.getFormat()) ? codeInfo.getFormat() : codeInfo.getFormat(), output);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void createCodeImage(QRCodeInfo info, File file){
        File parent = file.getParentFile();
        if(!parent.exists())parent.mkdirs();
        OutputStream output = null;
        try{
            output = new BufferedOutputStream(new FileOutputStream(file));
            createQRCode(info, output);
            output.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createCodeImage(QRCodeInfo info, String filePath){
        createCodeImage(info, new File(filePath));
    }
}
