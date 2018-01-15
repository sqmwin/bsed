package cn.bsed.service;

import cn.bsed.pojo.News;

import java.util.List;

/**
 * @author SQM
 * @Description:
 * @date 2018/1/15
 * @version: 1.0
 */
public interface NewsService {
    void add(News news);

    void delete(int id);

    void update(News news);

    News get(int id);

    List<News> listAll();

}
