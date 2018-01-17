package cn.bsed.service;

import cn.bsed.pojo.Category;

import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
public interface CategoryService {

    void add(Category category);

    void delete(int id);

    void update(Category category);

    Category get(int id);

    List<Category> listAll();
}
