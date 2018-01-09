package cn.bsed.controller;

import cn.bsed.pojo.Category;
import cn.bsed.pojo.Project;
import cn.bsed.service.CategoryService;
import cn.bsed.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProjectService projectService;

    /**
     * <p>   显示所有的分类
     *
     * @param model 分类列表
     * @return 主页
     */
    @RequestMapping("forehome")
    public String fore(Model model) {
        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);
        return "fore/home";
    }

    /**
     *<p>   显示指定分类类型的所有project
     *@param    categoryType 分类类型
     *@param    model   项目列表
     *@return   项目列表页面
     */
    @RequestMapping("list_projects_by_category_type")
    public String listProjectsByCategoryType(String categoryType,Model model) {
        List<Project> projects = projectService.listProjectsByCategoryType(categoryType);
        model.addAttribute("projects", projects);
        return "fore/projects";
    }

    /**
     *<p>   显示指定分类id的所有project
     *@param    categoryId 分类类型
     *@param    model   项目列表
     *@return   项目列表页面
     */
    @RequestMapping("list_projects_by_category_id")
    public String listProjectsByCategoryId(Integer categoryId,Model model) {
        List<Project> projects = projectService.listProjectsByCategoryId(categoryId);
        model.addAttribute("projects", projects);
        return "fore/projects";
    }

    /**
     * <p>   显示指定id的项目
     *
     * @param id    项目id
     * @param model 项目信息
     * @return 项目页面
     */
    @RequestMapping("show_project")
    public String showProject(Integer id, Model model) {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "fore/projectPage";
    }
}
