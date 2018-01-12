package cn.bsed.util.upload;

import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
public class FileUpLoad {
    //将表单中的文件上传至指定的服务器位置
    /**
     *<p>
     *@param file   要上传的文件
     *@param filePath   要上传文件的服务器路径
     *@return File   上传的文件
     */
    public static File saveFile(MultipartFile file, String filePath) throws IOException {
        //判断是否为空
        if (!file.isEmpty()) {
            File saveFile = new File(filePath);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            //转存文件
            file.transferTo(saveFile);
            return saveFile;
        }
        return null;
    }

    /**
     *<p> 将jpg后缀的文件转化成真正的jpg图片格式
     *@param file   要转化的文件
     *@return java.awt.image.BufferedImage  转化后的图片
     */
    public static BufferedImage changeToJpg(File file) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(file.getAbsolutePath());
            PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, true);
            pixelGrabber.grabPixels();
            int width = pixelGrabber.getWidth();
            int height = pixelGrabber.getHeight();
            final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
            final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[]) pixelGrabber.getPixels(), width * height);
            WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
            BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
            return img;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
