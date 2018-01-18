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
     * <p>   后台管理登陆页
     *
     * @return 后台管理登陆页
     */
    @RequestMapping(value = "/admin_login_page", method = RequestMethod.GET)
    public String loginPage() {
        return "admin/loginPage";
    }

    /**
     * <p>   显示所有的分类
     *
     * @param model 分类列表
     * @return 主页
     */
    @RequestMapping(value = "/forehome", method = RequestMethod.GET)
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
    @RequestMapping(value = "/list_projects_by_category_type", method = RequestMethod.GET)
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
    @RequestMapping(value = "/list_projects_by_category_id", method = RequestMethod.GET)
    public String listProjectsByCategoryId(Integer categoryId, Model model) {
        List<Project> projects = projectService.listProjectsByCategoryId(categoryId);
        model.addAttribute("projects", projects);
        return "fore/projects";
    }

    /**
     * listNews
     * <p>   显示所有新闻数据
     *
     * @param model 新闻数据List
     * @return java.lang.String  前台新闻列表页面
     */
    @RequestMapping(value = "/list_news", method = RequestMethod.GET)
    public String listNews(Model model) {
        List<News> newsList = newsService.listAll();
        model.addAttribute("newsList", newsList);
        return "fore/news";
    }

    /**
     * listCreators
     * <p>   显示所有主创数据及主创分类的数据
     *
     * @param categoryId 主创分类的id
     * @param model      全部主创数据的List与主创对应的分类
     * @return java.lang.String  前台主创列表页面
     */
    @RequestMapping(value = "/list_creators", method = RequestMethod.GET)
    public String listCreators(Integer categoryId, Model model) {
        Category category = categoryService.get(categoryId);
        List<Creator> creators = creatorService.listAll();
        model.addAttribute("category", category);
        model.addAttribute("creators", creators);
        return "fore/creator";
    }

    /**
     * listProfession
     * <p>   显示所有专家数据及专家分类的数据
     *
     * @param categoryId 专家分类的id
     * @param model      全部专家数据的list与专家对应的分类
     * @return java.lang.String  前台专家列表页面
     */
    @RequestMapping(value = "/list_profession", method = RequestMethod.GET)
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
     * @param model 项目的数据
     * @return 项目页面
     */
    @RequestMapping(value = "/show_project", method = RequestMethod.GET)
    public String showProject(Integer id, Model model) {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "fore/projectPage";
    }

    /**
     * showNews
     * <p>   显示指定id的新闻数据
     *
     * @param id    新闻的id
     * @param model 新闻的数据
     * @return java.lang.String  新闻页面
     */
    @RequestMapping(value = "/show_news", method = RequestMethod.GET)
    public String showNews(Integer id, Model model) {
        News news = newsService.get(id);
        model.addAttribute("news", news);
        return "fore/newsPage";
    }

    /**
     * showCreator
     * <p>   显示指定id的主创数据
     *
     * @param id    主创的id
     * @param model 主创的数据
     * @return java.lang.String  主创页面
     */
    @RequestMapping(value = "/show_creator", method = RequestMethod.GET)
    public String showCreator(Integer id, Model model) {
        Creator creator = creatorService.get(id);
        model.addAttribute("creator", creator);
        return "fore/creatorPage";
    }

    /**
     * showProfession
     * <p>   显示指定id的专家数据
     *
     * @param id    专家的id
     * @param model 专家的数据
     * @return java.lang.String  专家页面
     */
    @RequestMapping(value = "/show_profession", method = RequestMethod.GET)
    public String showProfession(Integer id, Model model) {
        Profession profession = professionService.get(id);
        model.addAttribute("profession", profession);
        return "fore/professionPage";
    }

    /**
     *followPage
     *<p>   跳转到follow页面
     *@return java.lang.String  follow页面
     */
    @RequestMapping(value = "/follow", method = RequestMethod.GET)
    public String followPage() {
        return "fore/follow";
    }

    /**
     *followPage
     *<p>   跳转到idea页面
     *@return java.lang.String  idea页面
     */
    @RequestMapping(value = "/idea", method = RequestMethod.GET)
    public String ideaPage() {
        return "fore/idea";
    }

    /**
     *followPage
     *<p>   跳转到honor页面
     *@return java.lang.String  honor页面
     */
    @RequestMapping(value = "/honor", method = RequestMethod.GET)
    public String honorPage() {
        return "fore/honor";
    }

    /**
     *followPage
     *<p>   跳转到join页面
     *@return java.lang.String  join页面
     */
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinPage() {
        return "fore/join";
    }

    /**
     *partnerPage
     *<p>   跳转到partner页面
     *@return java.lang.String  partner页面
     */
    @RequestMapping(value = "/partner", method = RequestMethod.GET)
    public String partnerPage() {
        return "fore/partner";
    }
}
