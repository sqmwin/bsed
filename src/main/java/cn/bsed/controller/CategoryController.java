package cn.bsed.controller;

import cn.bsed.pojo.Category;
import cn.bsed.service.CategoryService;
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
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * <p>   显示所有分类
     *
     * @param model 分类列表
     * @return 分类页面
     */
    @RequestMapping("admin_category_list")
    public String list(Model model) {
        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);
        return "admin/listCategory";
    }

    /**
     * <p>   新增分类
     *
     * @param model 分类列表
     * @return 分类页面
     */
    @RequestMapping("admin_category_add")
    public String add(Category category) {
        categoryService.add(category);
        return "redirect:admin_category_list";
    }

    /**
     * <p>   编辑分类
     *
     * @param category 得到的分类
     * @param model 编辑过后的分类
     * @return 分类页面
     */
    @RequestMapping("admin_category_edit")
    public String edit(Category category,Model model) {
        categoryService.update(category);
        return "redirect:admin_category_list";
    }
}
