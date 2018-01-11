package cn.bsed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
@Controller
@RequestMapping("")
public class FileUploadController {
    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("result")
    public String result() {
        return "/test/result";
    }

    /***
     * 保存文件
     *
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String strDirPath = request.getSession().getServletContext().getRealPath("/");
                System.out.println(strDirPath);
                String strDirPath2 = request.getServletContext().getRealPath("/");
                System.out.println(strDirPath2);

                String filePath = request.getSession().getServletContext().getRealPath("/") + "img/" +file.getOriginalFilename();
                System.out.println(filePath);
                File saveFile = new File(filePath);
                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }
                // 转存文件
                file.transferTo(saveFile);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping("fileUpload")
    public String filesUpload(@RequestParam("file") MultipartFile file) {
        if (file != null) {
                saveFile(file);
        }
        // 重定向
        return "redirect:result";
    }


    /**
     * 读取上传文件中得所有文件并返回
     * @return
     */
    @RequestMapping("list")
    public ModelAndView list() {
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        ModelAndView mav = new ModelAndView("list");
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
            System.out.println(fileNames[i]);
        }
        return mav;
    }
}
