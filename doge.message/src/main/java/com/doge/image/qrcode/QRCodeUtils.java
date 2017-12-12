package com.doge.image.qrcode;

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

    public void createQRCode(QRCodeInfo codeInfo, OutputStream output){
        BufferedImage bm = createQRCode(codeInfo);
        File logoFile = codeInfo.getLogoFile();
        if(logoFile!=null && logoFile.exists()){
            try{
                BufferedImage logoImg = ImageIO.read(logoFile);
                int logoWidth = logoImg.getWidth();
                int logoHeight = logoImg.getHeight();
                int width = bm.getWidth();
                int height = bm.getHeight();
                float ratio = codeInfo.getLogoRatio();
                if(ratio>0){
                    logoWidth = logoWidth>width*ratio ? (int)(width*ratio) : logoWidth;
                    logoHeight = logoHeight>height*ratio ? (int)(height*ratio) : logoHeight;
                }
                int x = (width-logoWidth)/2;
                int y = (height-logoHeight)/2;
                Graphics g = bm.getGraphics();
                g.drawImage(logoImg, x, y, logoWidth, logoHeight, null);
                String desc = codeInfo.getDesc();
                //int whiteWidth = 8;
                if(!StringUtils.isEmpty(desc)){
                    int whiteWidth = codeInfo.getHeight()-codeInfo.getBottomEnd()[1];
                    Font font = new Font("黑体", Font.BOLD, codeInfo.getFontSize());
                    int fontHeight = g.getFontMetrics(font).getHeight();
                    //计算需要多少行
                    int lineNum = 1;
                    int currentLineLen = 0;
                    for(int i=0;i<desc.length();i++){
                        char c = desc.charAt(i);
                        int charWidth = g.getFontMetrics(font).charWidth(c);
                        if(currentLineLen+charWidth>width){
                            lineNum++;
                            currentLineLen = 0;
                            continue;
                        }
                        currentLineLen += charWidth;
                    }
                    int totalFontHeight = fontHeight*lineNum;
                    int wordTopMargin = 4;
                    BufferedImage bm1 = new BufferedImage(width, height+totalFontHeight+wordTopMargin-whiteWidth, BufferedImage.TYPE_INT_RGB);
                    Graphics g1 = bm1.getGraphics();
                    if(totalFontHeight+wordTopMargin-whiteWidth>0){
                        g1.setColor(Color.WHITE);
                        g1.fillRect(0, height, width, totalFontHeight+wordTopMargin-whiteWidth);
                    }
                    g1.setColor(new Color(BLACK));
                    g1.setFont(font);
                    g1.drawImage(bm, 0, 0, null);
                    width = codeInfo.getBottomEnd()[0]-codeInfo.getBottomStart()[0];
                    height = codeInfo.getBottomEnd()[1]+1;
                    currentLineLen = 0;
                    int currentLineIndex = 0;
                    int baseLo = g1.getFontMetrics().getAscent();
                    for(int i=0;i<desc.length();i++){
                        String c = desc.substring(i, i+1);
                        int charWidth = g.getFontMetrics(font).stringWidth(c);
                        if(currentLineLen+charWidth>width){
                            currentLineIndex++;
                            currentLineLen = 0;
                            g1.drawString(c, currentLineLen + whiteWidth, height+baseLo+fontHeight*(currentLineIndex)+wordTopMargin);
                            currentLineLen = charWidth;
                            continue;
                        }
//                        g1.drawString(c, currentLineLen+whiteWidth, height+baseLo+fontHeight*(currentLineIndex) + wordTopMargin);
                        g1.drawString(c, currentLineLen+whiteWidth, baseLo-fontHeight*(currentLineIndex) - wordTopMargin);
                        currentLineLen += charWidth;
                    }
                    g1.dispose();
                    bm = bm1;
                }
            }catch(Exception e){
                e.printStackTrace();
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
