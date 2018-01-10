package cn.bsed.service.impl;

import cn.bsed.mapper.ProjectMapper;
import cn.bsed.pojo.Project;
import cn.bsed.pojo.ProjectExample;
import cn.bsed.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void add(Project project) {
        //设置创建日期
        Date createDate = new Date();
        project.setCreateDate(createDate);

        projectMapper.insert(project);
    }

    @Override
    public void delete(int id) {
        projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Project project) {
       projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public Project get(int id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> listProjectsByCategoryId(int categoryId) {
        ProjectExample example = new ProjectExample();
        example.createCriteria().andCategoryIdEqualTo(categoryId);
        example.setOrderByClause("id desc");
        return projectMapper.selectByExample(example);
    }

    @Override
    public List<Project> listProjectsByCategoryType(String categoryType) {
        ProjectExample example = new ProjectExample();
        example.createCriteria().andCategoryTypeEqualTo(categoryType);
        example.setOrderByClause("id desc");
        List<Project> projects = projectMapper.selectByExample(example);
        return projects;
    }

    @Override
    public List<Project> listAll() {
        return projectMapper.selectByExample(new ProjectExample());
    }
}
