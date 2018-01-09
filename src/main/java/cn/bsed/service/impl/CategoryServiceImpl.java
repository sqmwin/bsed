package cn.bsed.service.impl;

import cn.bsed.mapper.CategoryMapper;
import cn.bsed.pojo.Category;
import cn.bsed.pojo.CategoryExample;
import cn.bsed.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public List<Category> listAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }
}
