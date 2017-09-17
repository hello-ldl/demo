package cn.com.demo.test;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import cn.com.demo.util.security.BASE64Util;

public class MatrixToImageWriter {  
       
       private static final int BLACK = 0xFF000000;  
       private static final int WHITE = 0xFFFFFFFF;  
       private static final Map<EncodeHintType, Object> hints = new HashMap();// 二维码参数
       private static final String format = "png";// 默认二维码文件格式
       static {
    	   hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符编码
    	   hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);// 容错等级 L、M、Q、H 其中 L 为最低, H 为最高
    	   hints.put(EncodeHintType.MARGIN, 0);// 二维码与图片边距       
       }
       private MatrixToImageWriter() {}  
       
         
       public static BufferedImage toBufferedImage(BitMatrix matrix) {  
         int width = matrix.getWidth();  
         int height = matrix.getHeight();  
         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
         for (int x = 0; x < width; x++) {  
           for (int y = 0; y < height; y++) {  
             image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
           }  
         }  
         System.out.println();
         return image;  
       }  
       
         
       public static void writeToFile(BitMatrix matrix, String format, File file)  
           throws IOException {  
         BufferedImage image = toBufferedImage(matrix);  
         if (!ImageIO.write(image, format, file)) {  
           throw new IOException("Could not write an image of format " + format + " to " + file);  
         }  
       }  
       
         
       public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)  
           throws IOException {  
         BufferedImage image = toBufferedImage(matrix);  
         if (!ImageIO.write(image, format, stream)) {  
           throw new IOException("Could not write an image of format " + format);  
         }  
       }  
       
       public static void main(String[] args) throws Exception {  
           String text = "https://www.baidu.com?a=6";  
           int width = 90;  
           int height = 90;  
           //二维码的图片格式  
           //内容所使用编码  
           BitMatrix bitMatrix = new MultiFormatWriter().encode(text,  
                   BarcodeFormat.QR_CODE, width, height, hints);  
           //生成二维码  
//           File outputFile = new File("d:"+File.separator+"new." + format);  
//           MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile); 
           ByteArrayOutputStream outputFile = new ByteArrayOutputStream();
           MatrixToImageWriter.writeToStream(bitMatrix, format, outputFile);  
           System.out.println(BASE64Util.encode(outputFile.toByteArray()));
     
       } 
       
     }  