package cn.bsed.controller;

import cn.bsed.pojo.Creator;
import cn.bsed.service.CreatorService;
import cn.bsed.util.page.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author SQM
 * @date 2018/1/15
 * @version: 1.0
 */
@Controller
@RequestMapping("")
public class CreatorController {
    @Autowired
    CreatorService creatorService;

    /**
     *listAll
     *<p>   获取所有主创数据并跳转到主创管理页面
     *@param page   分页对象
     *@param model  所有主创数据及分页数据
     *@return java.lang.String  主创管理页面
     */
    @RequestMapping(value = "/admin_creator_list",method = RequestMethod.GET)
    public String listAll(Page page, Model model) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Creator> creators = creatorService.listAll();

        int total = (int) new PageInfo<>(creators).getTotal();
        page.setTotal(total);

        model.addAttribute("creators", creators);
        model.addAttribute("page", page);
        return "admin/listCreator";
    }

    /**
     *add
     *<p>   添加一条主创数据
     *@param creator    要添加的主创数据
     *@return java.lang.String  主创列表Controller
     */
    @RequestMapping(value = "/admin_creator_add",method = RequestMethod.POST)
    public String add(Creator creator) {
        String empty = "";
        if (!empty.equals(creator.getName())) {
            creator.setCategoryId(9);
            creator.setCategoryType("type_other");
            creatorService.add(creator);
        }
        return "redirect:/admin_creator_list";
    }

    /**
     *delete
     *<p>   删除一条主创数据
     *@param id 要删除的主创数据的id
     *@param model  判断是否已经删除此数据的boolean结果
     *@return java.lang.String  删除主创通知页面
     */
    @RequestMapping(value = "/admin_creator_delete", method = RequestMethod.GET)
    public String delete(Integer id, Model model) {
        creatorService.delete(id);
        List<Creator> creators = creatorService.listAll();
        for (Creator creator : creators) {
            if (id.equals(creator.getId())) {
                model.addAttribute("result", false);
            } else {
                model.addAttribute("result", true);
            }
        }
        return "admin/deleteCreator";
    }

    /**
     *edit
     *<p>   编辑更改一条主创数据
     *@param creator  编辑后的主创数据
     *@return java.lang.String  主创列表Controller
     */
    @RequestMapping(value = "/admin_creator_edit", method = RequestMethod.POST)
    public String edit(Creator creator) {
        creatorService.update(creator);
        return "redirect:/admin_creator_list";
    }

    /**
     *selectImage
     *<p>   选择或更改指定id的主创的图片
     *@param id 要更改图片的主创的id
     *@param imageUrl 要更改的图片的url
     *@return java.lang.String  主创列表Controller
     */
    @RequestMapping(value = "/admin_creator_image_select", method = RequestMethod.GET)
    public String selectImage(Integer id, String imageUrl) {
        Creator creator = creatorService.get(id);
        creator.setImageUrl(imageUrl);
        creatorService.update(creator);
        return "redirect:/admin_creator_list";
    }
}
