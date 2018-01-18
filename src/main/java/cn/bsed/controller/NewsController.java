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
@RequestMapping("/admin")
public class NewsController {
    @Autowired
    NewsService newsService;

    /**
     *listAll
     *<p>   获取全部新闻数据并通过分页展示
     *@param page   分页对象
     *@param model  所有新闻数据及分页对象
     *@return java.lang.String  后台新闻管理页面
     */
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

    /**
     *add
     *<p>   添加一条新闻数据
     *@param news   被添加的新闻数据
     *@return java.lang.String  新闻列表Controller
     */
    @RequestMapping(value = "/admin_news_add",method = RequestMethod.POST)
    public String add(News news) {
        String empty = "";
        if (!empty.equals(news.getTitle())) {
            news.setCategoryId(7);
            news.setCategoryType("type_other");
            Date date = new Date();
            news.setCreateDate(date);
            newsService.add(news);
        }
        return "redirect:/admin/admin_news_list";
    }

    /**
     *selectImage
     *<p>   选择或更改指定id新闻的图片
     *@param id 要更改图片的新闻的id
     *@param imageUrl 要更改图片的url
     *@return java.lang.String  新闻列表Controller
     */
    @RequestMapping(value = "/admin_news_image_select",method = RequestMethod.GET)
    public String selectImage(Integer id, String imageUrl) {
        News news = newsService.get(id);
        news.setImageUrl(imageUrl);
        newsService.update(news);
        return "redirect:/admin/admin_news_list";
    }

    /**
     *delete
     *<p>   删除指定id的新闻数据
     *@param id 要删除的新闻的id
     *@param model  是否删除成功的结果
     *@return java.lang.String  删除新闻通知页面
     */
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

    /**
     *edit
     *<p>   编辑新闻数据
     *@param news   编辑后的新闻数据
     *@return java.lang.String  新闻列表Controller
     */
    @RequestMapping(value = "/admin_news_edit",method = RequestMethod.POST)
    public String edit(News news) {
        newsService.update(news);
        return "redirect:/admin/admin_news_list";
    }
}
