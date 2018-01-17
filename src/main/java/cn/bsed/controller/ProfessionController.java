package cn.bsed.controller;

import cn.bsed.pojo.Profession;
import cn.bsed.service.ImageService;
import cn.bsed.service.ProfessionService;
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
 * @date 2018/1/16
 * @version: 1.0
 */
@Controller
@RequestMapping("")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/admin_profession_list", method = RequestMethod.GET)
    public String listAll(Page page, Model model) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Profession> professions = professionService.listAll();

        int total = (int) new PageInfo<>(professions).getTotal();
        page.setTotal(total);

        model.addAttribute("page", page);
        model.addAttribute("professions", professions);

        return "admin/listProfession";
    }

    @RequestMapping(value = "/admin_profession_add", method = RequestMethod.POST)
    public String add(Profession profession) {
        profession.setCategoryId(10);
        profession.setCategoryType("type_other");
        professionService.add(profession);
        return "redirect:/admin_profession_list";
    }

    @RequestMapping(value = "/admin_profession_edit", method = RequestMethod.POST)
    public String edit(Profession profession) {
        professionService.update(profession);
        return "redirect:/admin_profession_list";
    }

    @RequestMapping(value = "/admin_profession_delete", method = RequestMethod.GET)
    public String delete(Integer id, Model model) {
        professionService.delete(id);
        List<Profession> professions = professionService.listAll();
        for (Profession profession : professions) {
            if (id.equals(profession.getId())) {
                model.addAttribute("result", false);
            } else {
                model.addAttribute("result", true);
            }
        }
        return "admin/deleteProfession";
    }

    @RequestMapping(value = "/admin_profession_image_select", method = RequestMethod.GET)
    public String selectImage(Integer id, String imageUrl) {
        Profession profession = professionService.get(id);
        profession.setImageUrl(imageUrl);
        professionService.update(profession);
        return "redirect:/admin_profession_list";
    }

}
