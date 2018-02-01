package cn.bsed.service.impl;

import cn.bsed.exception.ImageUploadException;
import cn.bsed.mapper.ImageMapper;
import cn.bsed.pojo.Image;
import cn.bsed.pojo.ImageExample;
import cn.bsed.service.ImageService;
import cn.bsed.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

    @Override
    public void add(Image image) {
        imageMapper.insert(image);
    }

    @Override
    public void delete(int id) {
        imageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Image get(int id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Image> listAll() {
        ImageExample example = new ImageExample();
        example.setOrderByClause("id desc");
        return imageMapper.selectByExample(example);
    }

    @Override
    public String upload(HttpSession session, MultipartFile file) throws ImageUploadException, IOException {
        final long fileSize = file.getSize();
        final long maxSize = 2 * 1024 * 1024;
        //判断文件是否为空
        if (file.isEmpty()) {
            throw new ImageUploadException("请选择图片");
        } else if (fileSize > maxSize) {
            throw new ImageUploadException("上传图片文件过大，不能超过2M");
        } else {
            String originalFilename = file.getOriginalFilename();
            String jpgEnd = ".jpg";
            String pngEnd = ".png";
            //判断文件扩展名是否为jpg和png
            if (!(originalFilename.endsWith(jpgEnd) || originalFilename.endsWith(pngEnd))) {
                throw new ImageUploadException("文件格式错误，只能是" + jpgEnd + "或" + pngEnd + "文件");
            } else if (originalFilename.endsWith(jpgEnd) || originalFilename.endsWith(pngEnd)) {
                String fileRelativePath = "/img/" + System.currentTimeMillis() + "_" + originalFilename;
                String fileAbsolutePath = session.getServletContext().getRealPath("") + fileRelativePath;

                String contextPath = session.getServletContext().getContextPath();
                System.out.println(contextPath);
                
                System.out.println(fileAbsolutePath);
                File saveFile = FileUpLoad.saveFile(file, fileAbsolutePath);
                if (saveFile != null) {
                    //转换成正真的图片格式
                    FileUpLoad.changeToJpg(saveFile);
                    //将图片地址存入数据库
                    Image image = new Image();
                    image.setUrl(fileRelativePath);
                    imageMapper.insert(image);
                    return "上传成功";
                }
            }
        }
        return "上传失败";
    }
}
