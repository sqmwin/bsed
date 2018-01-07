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
     * <p>   显示所有的分类
     *
     * @param model 分类列表
     * @return 主页
     */
    @RequestMapping("forehome")
    public String fore(Model model) {
        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        return "fore/home";
    }
}
