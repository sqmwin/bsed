package cn.bsed.controller;

import cn.bsed.exception.ImageUploadException;
import cn.bsed.pojo.Image;
import cn.bsed.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *
 * @author SQM
 * @since 2018/1/11
 */
@Controller
@RequestMapping("/admin")
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
    public String uploadImage(HttpSession session, @RequestParam("image") MultipartFile file) {
        try {
            String success = imageService.upload(session, file);
            session.setAttribute("result", success);
        } catch (ImageUploadException e) {
            session.setAttribute("result", e.getMessage());
        } catch (IOException e) {
            session.setAttribute("result", e.getLocalizedMessage());
        }
        return "redirect:/admin/admin_image_list";
    }
    
    @Autowired
    CommonsMultipartResolver multipartResolver;
    
    /**
     * 通过requset的multipart/data判断后，获取每个图片
     */
    @RequestMapping(value = "/admin_image_upload", method = RequestMethod.POST)
    public String uploadImageByResolver(HttpServletRequest request,Model model) {
        long time = System.currentTimeMillis();
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> names = mRequest.getFileNames();
            while (names.hasNext()) {
                String name = names.next();
                List<MultipartFile> fileList = mRequest.getFiles(name);
                for (MultipartFile file : fileList) {
                    if (!file.isEmpty()) {
                        String originalName = file.getOriginalFilename();
                        String relativePath = "/img/" + System.currentTimeMillis() + "_" + originalName;
                        String absolutePath = request.getServletContext().getRealPath("") + relativePath;
                        File image = new File(absolutePath);
                        if (!image.getParentFile().exists()) {
                            image.getParentFile().mkdirs();
                        }
                        try {
                            file.transferTo(image);
                            Image i = new Image();
                            i.setUrl(relativePath);
                            imageService.add(i);
                        } catch (IOException e) {
                            model.addAttribute("message", e.getMessage());
                        }
                    }
                }
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println("MultipartRequest的上传时间：" + time);
        return "redirect:/admin/admin_image_list";
    }
    
    @RequestMapping(value = "/admin_image_upload_mul", method = RequestMethod.POST)
    public String imageUploadMul(HttpSession session,MultipartFile[] files, Model model) {
        long time = System.currentTimeMillis();
        if (files != null) {
            for (MultipartFile file : files) {
                String originalName = file.getOriginalFilename();
                String relativePath = "/img/" + System.currentTimeMillis() + "_" + originalName;
                String absolutePath = session.getServletContext().getRealPath("") + relativePath;
                File image = new File(absolutePath);
                if (!image.getParentFile().exists()) {
                    image.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(image);
                    Image i = new Image();
                    i.setUrl(relativePath);
                    imageService.add(i);
                } catch (IOException e) {
                    model.addAttribute("message", e.getMessage());
                }
    
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println("MultipartFile[]的上传时间：" + time);
        return "redirect:/admin/admin_image_list";
    }
    /**
     *delete
     *<p>   删除指定id的图片
     *@param id 要删除的图片的id
     *@return java.lang.String  删除通知页面
     */
    @RequestMapping(value = "/admin_image_delete", method = RequestMethod.GET)
    public String delete(Integer id) {
        
        imageService.delete(id);
        return "admin/deleteImage";
    }

}
