package cn.bsed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("")
public class AdminController {

    /**
     *<p>   后台管理主页
     *@return   后台管理主页
     */
    @RequestMapping("admin_home")
    public String adminHomePage(){
        return "admin/home";
    }


}
