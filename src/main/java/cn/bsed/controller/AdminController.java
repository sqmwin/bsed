package cn.bsed.controller;

import cn.bsed.pojo.Category;
import cn.bsed.pojo.Project;
import cn.bsed.service.CategoryService;
import cn.bsed.service.ProjectService;
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
    @Autowired
    ProjectService projectService;

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
     *@param id 被编辑的分类的id
     *@param model 被编辑的分类
     *@return   分类编辑页面
     */
    @RequestMapping("admin_edit_category_page")
    public String adminEditCategoryPage(Integer id, Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

    /**
     *<p>   项目编辑页面
     *@param id 被编辑的项目的id
     *@param model 被编辑的项目
     *@return   项目编辑页面
     */
    @RequestMapping("admin_edit_project_page")
    public String adminEditProjectPage(Integer id, Model model){
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "admin/editProject";
    }

}
