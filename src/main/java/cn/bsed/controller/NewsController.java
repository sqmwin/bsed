package cn.bsed.controller;

import cn.bsed.pojo.News;
import cn.bsed.service.NewsService;
import cn.bsed.util.page.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * @author SQM
 * @date 2018/1/15
 * @version: 1.0
 */
@Controller
@RequestMapping("")
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/admin_news_list",method = RequestMethod.GET)
    public String listAll(Page page, Model model) {
        //page.setCount(2);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<News> news = newsService.listAll();

        int total = (int) new PageInfo<>(news).getTotal();
        page.setTotal(total);

        model.addAttribute("news", news);
        model.addAttribute("page", page);
        return "admin/listNews";
    }

    @RequestMapping(value = "/admin_news_add",method = RequestMethod.POST)
    public String add(News news) {
        news.setCategoryId(7);
        news.setCategoryType("type_other");
        Date date = new Date();
        news.setCreateDate(date);
        newsService.add(news);
        return "redirect:admin_news_list";
    }

    @RequestMapping(value = "/admin_news_image_select",method = RequestMethod.GET)
    public String selectImage(Integer id, String imageUrl) {
        News news = newsService.get(id);
        news.setImageUrl(imageUrl);
        newsService.update(news);
        return "redirect:admin_news_list";
    }

    @RequestMapping(value = "/admin_news_delete",method = RequestMethod.GET)
    public String delete(Integer id,Model model) {
        newsService.delete(id);
        List<News> news = newsService.listAll();
        for (News news1 : news) {
            if (id.equals(news1.getId())) {
                model.addAttribute("result", false);
            } else {
                model.addAttribute("result", true);
            }
        }
        return "admin/deleteNews";
    }

    @RequestMapping(value = "/admin_news_edit",method = RequestMethod.POST)
    public String edit(News news) {
        newsService.update(news);
        return "redirect:admin_news_list";
    }
}
