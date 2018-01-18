package cn.bsed.controller;

import cn.bsed.pojo.Category;
import cn.bsed.service.CategoryService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * <p>   显示所有分类
     *
     * @param model 分类列表
     * @return 分类页面
     */
    @RequestMapping(value = "/admin_category_list",method = RequestMethod.GET)
    public String list(Model model) {
        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);
        return "admin/listCategory";
    }

    /**
     * <p>   新增分类
     *
     * @param category 新增的分类
     * @return 分类页面
     */
    @RequestMapping(value = "/admin_category_add",method = RequestMethod.POST)
    public String add(Category category) {
        String nothing = "";
        //判断分类名称是否为空
        if (!nothing.equals(category.getName())) {
            categoryService.add(category);
        }
        return "redirect:/admin/admin_category_list";
    }

    /**
     * <p>   编辑分类
     *
     * @param category 得到的分类
     * @return 分类页面
     */
    @RequestMapping(value = "/admin_category_edit",method = RequestMethod.POST)
    public String edit(Category category) {
        categoryService.update(category);
        return "redirect:/admin/admin_category_list";
    }

    /**
     * <p>   删除分类
     *
     * @param id 要删除分类的id
     * @param model 删除的结果
     * @return 删除通知页面
     */
    @RequestMapping(value = "/admin_category_delete",method = RequestMethod.GET)
    public String delete(Integer id,Model model) {
        categoryService.delete(id);
        List<Category> categories = categoryService.listAll();
        for (Category category : categories) {
            if (id.equals(category.getId())) {
                model.addAttribute("result", false);
            } else {
                model.addAttribute("result", true);
            }
        }
        return "admin/deleteCategory";
    }

    /**
     * <p>   以json字符串形式显示所有分类
     *
     * @param response 服务器响应
     * @return category所有数据的json字符串
     */
    @RequestMapping(value = "/admin_category_list_with_json",method = RequestMethod.GET)
    @ResponseBody
    public String listWithJson(HttpServletResponse response) {
        List<Category> categories = categoryService.listAll();
        response.setCharacterEncoding("utf-8");
        return JSON.toJSONString(categories);
    }
}
