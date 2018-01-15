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

    @RequestMapping(value = "/admin_creator_add",method = RequestMethod.POST)
    public String add(Creator creator) {
        creator.setCategoryId(9);
        creator.setCategoryType("type_other");
        creatorService.add(creator);
        return "redirect:admin_creator_list";
    }

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

    @RequestMapping(value = "/admin_creator_edit", method = RequestMethod.POST)
    public String edit(Creator creator) {
        creatorService.update(creator);
        return "redirect:admin_creator_list";
    }


    @RequestMapping(value = "/admin_creator_image_select", method = RequestMethod.GET)
    public String selectImage(Integer id, String imageUrl) {
        Creator creator = creatorService.get(id);
        creator.setImageUrl(imageUrl);
        creatorService.update(creator);
        return "redirect:admin_creator_list";
    }
}
