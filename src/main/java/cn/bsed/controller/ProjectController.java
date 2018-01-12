package cn.bsed.controller;

import cn.bsed.pojo.Project;
import cn.bsed.service.CategoryService;
import cn.bsed.service.ProjectService;
import cn.bsed.util.page.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    CategoryService categoryService;

    /**
     * <p>   显示所有项目
     *
     * @param model 项目列表
     * @return 项目管理页面
     */
    @RequestMapping("admin_project_list")
    public String listAllProjects(Page page,Model model) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Project> projects = projectService.listAll();

        int total = (int) new PageInfo<>(projects).getTotal();
        page.setTotal(total);

        model.addAttribute("projects", projects);
        model.addAttribute("page", page);
        return "admin/listProject";
    }

    /**
     * <p>   新增项目
     *
     * @param project 要新增的项目
     * @param year    要新增的项目的设计时间
     * @return 项目管理页面
     */
    @RequestMapping("admin_project_add")
    public String add(Project project, String year) throws ParseException {
        //设置设计时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date time = simpleDateFormat.parse(year);
        project.setTime(time);
        projectService.add(project);
        return "redirect:admin_project_list";
    }

    /**
     * <p>   编辑项目
     *
     * @param project 要编辑的项目
     * @return 项目管理页面
     */
    @RequestMapping("admin_project_edit")
    public String edit(Project project, String year) throws ParseException {
        //设置设计时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date time = simpleDateFormat.parse(year);
        project.setTime(time);
        projectService.update(project);
        return "redirect:admin_project_list";
    }

    /**
     * <p>   删除项目
     *
     * @param id    要删除项目的id
     * @param model 删除的结果
     * @return 删除项目通知页面
     */
    @RequestMapping("admin_project_delete")
    public String delete(Integer id, Model model) {
        projectService.delete(id);
        List<Project> projects = projectService.listAll();
        for (Project project : projects) {
            if (id.equals(project.getId())) {
                model.addAttribute("result", "false");
            } else {
                model.addAttribute("result", "true");
            }
        }
        return "admin/deleteProject";
    }

    //选择项目图片
    @RequestMapping("admin_image_select")
    public String selectImage(@RequestParam("id") Integer id,@RequestParam("imageUrl") String imageUrl) {
        Project project = projectService.get(id);
        project.setImageUrl(imageUrl);
        projectService.update(project);
        return "redirect:admin_project_list";
    }
}
