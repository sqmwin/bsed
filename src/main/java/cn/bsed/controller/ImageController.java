package cn.bsed.controller;

import cn.bsed.pojo.Image;
import cn.bsed.service.ImageService;
import cn.bsed.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
@Controller
@RequestMapping("")
public class ImageController {
    @Autowired
    ImageService imageService;

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    HttpServletRequest request;

    @RequestMapping("admin_image_list")
    public String list(Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("images", images);
        return "admin/listImage";
    }

    @RequestMapping("admin_image_add")
    public String add(@RequestParam("image") MultipartFile file) {
        //通过request获取服务器输出路径
        String filePath = request.getSession().getServletContext().getRealPath("/") + "img/" + file.getOriginalFilename();
        //存储到服务器
        try {
            FileUpLoad.saveFile(file, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取返回的文件名存入数据库image表中

        return "redirect:admin_image_list";
    }
}
