package cn.bsed.controller;

import cn.bsed.pojo.Image;
import cn.bsed.service.ImageService;
import cn.bsed.util.upload.FileUpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *
 * @author SQM
 * @since 2018/1/11
 */
@Controller
@RequestMapping("")
public class ImageController {
    @Autowired
    ImageService imageService;

    /**
     *<p>通过Spring的autowired注解获取spring默认配置的request
     */
    @Autowired
    HttpServletRequest request;

    /**
     * <p>   获取所有image表数据
     *
     * @param model 所有image的数据
     * @return 图库管理页面
     */
    @RequestMapping(value = "/admin_image_list",method = RequestMethod.GET)
    public String list(Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("images", images);
        return "admin/listImage";
    }

    /**
     * <p>   新增图片
     *
     * @param file 上传的图片
     * @return 图库管理页面
     */
    @RequestMapping(value = "/admin_image_add",method = RequestMethod.POST)
    public String add(@RequestParam("image") MultipartFile file,Model model) {
        long fileSize = file.getSize();
        long maxSize = 2090000L;
        if (fileSize == 0) {
            model.addAttribute("result", "请选择图片");
            return "/error/errorFileUpload";
        } else if (fileSize > maxSize) {
            model.addAttribute("result", "文件过大，不能超过2M");
            return "/error/errorFileUpload";
        } else {
            //判断是否为jpg或png格式的图片
            String originalFilename = file.getOriginalFilename();
            String jpgEnd = ".jpg";
            String pngEnd = ".png";
            if (!(originalFilename.endsWith(jpgEnd) || originalFilename.endsWith(pngEnd))) {
                model.addAttribute("result", "文件格式错误，只能是" + jpgEnd + "或" + pngEnd + "文件");
                return "/error/errorFileUpload";
            } else {
                //通过request获取服务器输出路径
                String fileRelativePath = "img/" + System.currentTimeMillis() + "_" + originalFilename;
                String fileAbsolutePath = request.getSession().getServletContext().getRealPath("/") + fileRelativePath;
                //存储到服务器
                try {
                    File saveFile = FileUpLoad.saveFile(file, fileAbsolutePath);
                    if (saveFile != null) {
                        FileUpLoad.changeToJpg(saveFile);
                        //获取返回的文件名存入数据库image表中
                        Image image = new Image();
                        image.setUrl(fileRelativePath);
                        imageService.add(image);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/admin_image_list";
    }

    /**
     *delete
     *<p>   删除指定id的图片
     *@param id 要删除的图片的id
     *@return java.lang.String  删除通知页面
     */
    @RequestMapping(value = "/admin_image_delete",method = RequestMethod.GET)
    public String delete(Integer id) {
        imageService.delete(id);
        return "admin/deleteImage";
    }

    /**
     * <p>   新增图片，以jsonString返回上传结果
     *
     * @param file 上传的图片
     * @return 图库管理页面
     */
    @RequestMapping(value = "/admin_image_add_with_json",method = RequestMethod.POST)
    @ResponseBody
    public String addWithJson(@RequestParam("image_json") MultipartFile file, HttpServletResponse response) {
        long fileSize = file.getSize();
        long maxSize = 2090000L;
        response.setCharacterEncoding("utf-8");
        if (fileSize == 0) {
            return "请选择图片";
        } else if (fileSize > maxSize) {
            return "文件过大，不能超过2M";
        } else {
            //判断是否为jpg或png格式的图片
            String originalFilename = file.getOriginalFilename();
            String jpgEnd = ".jpg";
            String pngEnd = ".png";
            if (!(originalFilename.endsWith(jpgEnd) || originalFilename.endsWith(pngEnd))) {
                return "文件格式错误，只能是\" + jpgEnd + \"或\" + pngEnd + \"文件";
            } else {
                //通过request获取服务器输出路径
                String fileRelativePath = "img/" + System.currentTimeMillis() + "_" + originalFilename;
                String fileAbsolutePath = request.getSession().getServletContext().getRealPath("/") + fileRelativePath;
                //存储到服务器
                try {
                    File saveFile = FileUpLoad.saveFile(file, fileAbsolutePath);
                    if (saveFile != null) {
                        FileUpLoad.changeToJpg(saveFile);
                        //获取返回的文件名存入数据库image表中
                        Image image = new Image();
                        image.setUrl(fileRelativePath);
                        imageService.add(image);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "上传成功";
    }
}
