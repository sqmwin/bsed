package cn.bsed.controller;

import cn.bsed.pojo.*;
import cn.bsed.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @Autowired
    NewsService newsService;
    @Autowired
    CreatorService creatorService;
    @Autowired
    ProfessionService professionService;

    /**
     * <p>   显示所有的分类
     *
     * @param model 分类列表
     * @return 主页
     */
    @RequestMapping(value = "/forehome",method = RequestMethod.GET)
    public String fore(Model model) {
        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);
        return "fore/home";
    }

    /**
     * <p>   显示指定分类类型的所有project
     *
     * @param categoryType 分类类型
     * @param model        项目列表
     * @return 项目列表页面
     */
    @RequestMapping(value = "/list_projects_by_category_type",method = RequestMethod.GET)
    public String listProjectsByCategoryType(String categoryType, Model model) {
        List<Project> projects = projectService.listProjectsByCategoryType(categoryType);
        model.addAttribute("projects", projects);
        return "fore/projects";
    }

    /**
     * <p>   显示指定分类id的所有project
     *
     * @param categoryId 分类类型
     * @param model      项目列表
     * @return 项目列表页面
     */
    @RequestMapping(value = "/list_projects_by_category_id",method = RequestMethod.GET)
    public String listProjectsByCategoryId(Integer categoryId, Model model) {
        List<Project> projects = projectService.listProjectsByCategoryId(categoryId);
        model.addAttribute("projects", projects);
        return "fore/projects";
    }

    @RequestMapping(value = "/list_news",method = RequestMethod.GET)
    public String listNews(Model model) {
        List<News> newsList = newsService.listAll();
        model.addAttribute("newsList", newsList);
        return "fore/news";
    }
    @RequestMapping(value = "/list_creators",method = RequestMethod.GET)
    public String listCreators(Integer categoryId, Model model) {
        Category category = categoryService.get(categoryId);
        List<Creator> creators = creatorService.listAll();
        model.addAttribute("category", category);
        model.addAttribute("creators", creators);
        return "fore/creator";
    }

    @RequestMapping(value = "/list_profession",method = RequestMethod.GET)
    public String listProfession(Integer categoryId, Model model) {
        Category category = categoryService.get(categoryId);
        List<Profession> professions = professionService.listAll();
        model.addAttribute("category", category);
        model.addAttribute("profession", professions);
        return "fore/profession";
    }

    /**
     * <p>   显示指定id的项目
     *
     * @param id    项目id
     * @param model 项目信息
     * @return 项目页面
     */
    @RequestMapping(value = "/show_project",method = RequestMethod.GET)
    public String showProject(Integer id, Model model) {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "fore/projectPage";
    }

    @RequestMapping(value = "/show_news",method = RequestMethod.GET)
    public String showNews(Integer id, Model model) {
        News news = newsService.get(id);
        model.addAttribute("news", news);
        return "fore/newsPage";
    }

    @RequestMapping(value = "/show_creator",method = RequestMethod.GET)
    public String showCreator(Integer id, Model model) {
        Creator creator = creatorService.get(id);
        model.addAttribute("creator", creator);
        return "fore/creatorPage";
    }

    @RequestMapping(value = "/show_profession",method = RequestMethod.GET)
    public String showProfession(Integer id, Model model) {
        Profession profession = professionService.get(id);
        model.addAttribute("profession", profession);
        return "fore/professionPage";
    }


}
