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
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProjectService projectService;
    @Autowired
    ImageService imageService;
    @Autowired
    NewsService newsService;
    @Autowired
    CreatorService creatorService;
    @Autowired
    ProfessionService professionService;

    /**
     * <p>   后台管理主页
     *
     * @return 后台管理主页
     */
    @RequestMapping(value = "/admin_home",method = RequestMethod.GET)
    public String adminHomePage() {
        return "admin/home";
    }

    /**
     * <p>   分类编辑页面
     *
     * @param id    被编辑的分类的id
     * @param model 被编辑的分类
     * @return 分类编辑页面
     */
    @RequestMapping(value = "/admin_edit_category_page",method = RequestMethod.GET)
    public String adminEditCategoryPage(Integer id, Model model) {
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

    /**
     * <p>   项目编辑页面
     *
     * @param id    被编辑的项目的id
     * @param model 被编辑的项目
     * @return 项目编辑页面
     */
    @RequestMapping(value = "/admin_edit_project_page",method = RequestMethod.GET)
    public String adminEditProjectPage(Integer id, Model model) {
        Project project = projectService.get(id);
        model.addAttribute("project", project);
        return "admin/editProject";
    }

    /**
     * <p>   新闻编辑页面
     *
     * @param id    被编辑的新闻的id
     * @param model 被编辑的新闻条目的数据
     * @return 新闻编辑页面
     */
    @RequestMapping(value = "/admin_edit_news_page",method = RequestMethod.GET)
    public String adminEditNewsPage(Integer id, Model model) {
        News news = newsService.get(id);
        model.addAttribute("news", news);
        return "admin/editNews";
    }

    /**
     *adminEditCreatorPage
     *<p>   主创编辑页面
     *@param id 被编辑的主创的id
     *@param model 被编辑的主创条目数据
     *@return java.lang.String  主创编辑页面
     */
    @RequestMapping(value = "/admin_edit_creator_page",method = RequestMethod.GET)
    public String adminEditCreatorPage(Integer id, Model model) {
        Creator creator = creatorService.get(id);
        model.addAttribute("creator", creator);
        return "admin/editCreator";
    }

    /**
     *adminEditProfessionPage
     *<p>   专家编辑页面
     *@param id 被编辑的专家的id
     *@param model 被编辑的专家条目数据
     *@return java.lang.String  专家编辑页面
     */
    @RequestMapping(value = "/admin_edit_profession_page",method = RequestMethod.GET)
    public String adminEditProfessionPage(Integer id, Model model) {
        Profession profession = professionService.get(id);
        model.addAttribute("profession", profession);
        return "admin/editProfession";
    }

    /**
     *<p>项目图片选择页面
     *
     *@param id 项目的id
     *@param model  项目的id及所有image数据
     *@return java.lang.String  项目图片选择页面
     */
    @RequestMapping(value = "/admin_select_project_image_page",method = RequestMethod.GET)
    public String adminSelectProjectImagePage(Integer id, Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("project_id", id);
        model.addAttribute("images", images);
        return "admin/selectProjectImage";
    }

    /**
     *<p>新闻图片选择页面
     *
     *@param id 新闻的id
     *@param model  新闻的id及所有image数据
     *@return java.lang.String  新闻图片选择页面
     */
    @RequestMapping(value = "/admin_select_news_image_page",method = RequestMethod.GET)
    public String adminSelectNewsImagePage(Integer id, Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("news_id", id);
        model.addAttribute("images", images);
        return "admin/selectNewsImage";
    }

    /**
     *adminSelectCreatorImagePage
     *<p>主创图片选择页面
     *@param id 主创的id
     *@param model  主创id与所有的image数据
     *@return java.lang.String  主创图片选择页面
     */
    @RequestMapping(value = "/admin_select_creator_image_page",method = RequestMethod.GET)
    public String adminSelectCreatorImagePage(Integer id, Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("creator_id", id);
        model.addAttribute("images", images);
        return "admin/selectCreatorImage";
    }

    /**
     *adminSelectProfessionImagePage
     *<p>   专家图片选择页面
     *@param id 专家的id
     *@param model  传出的专家条目的id值与所有image数据
     *@return java.lang.String  专家图片选择页面
     */
    @RequestMapping(value = "/admin_select_profession_image_page",method = RequestMethod.GET)
    public String adminSelectProfessionImagePage(Integer id, Model model) {
        List<Image> images = imageService.listAll();
        model.addAttribute("profession_id", id);
        model.addAttribute("images", images);
        return "admin/selectProfessionImage";
    }
    /**
     *<p>上传失败页面
     *
     *@return java.lang.String  上传文件失败页面
     */
    @RequestMapping(value = "/errorFileUpload",method = RequestMethod.GET)
    public String errorFileUpload() {
        return "error/errorFileUpload";
    }

}
