package cn.bsed.controller;

import cn.bsed.pojo.Category;
import cn.bsed.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    CategoryService categoryService;

    /**
     *<p>   后台管理主页
     *@return   后台管理主页
     */
    @RequestMapping("admin_home")
    public String adminHomePage(){
        return "admin/home";
    }

    /**
     *<p>   分类编辑页面
     *@return   分类编辑页面
     */
    @RequestMapping("admin_edit_category_page")
    public String adminEditCategoryPage(Integer id, Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

}
