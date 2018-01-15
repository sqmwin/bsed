package cn.bsed.service.impl;

import cn.bsed.mapper.NewsMapper;
import cn.bsed.pojo.News;
import cn.bsed.pojo.NewsExample;
import cn.bsed.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @Description:
 * @date 2018/1/15
 * @version: 1.0
 */
@Service
public class NewsServiceImpl  implements NewsService{
    @Autowired
    NewsMapper newsMapper;

    @Override
    public void add(News news) {
        newsMapper.insert(news);
    }

    @Override
    public void delete(int id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(News news) {
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public News get(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<News> listAll() {
        return newsMapper.selectByExample(new NewsExample());
    }

}
