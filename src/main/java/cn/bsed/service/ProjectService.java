package cn.bsed.service;

import cn.bsed.pojo.Project;

import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
public interface ProjectService {
    void add(Project project);

    void delete(int id);

    void update(Project project);

    Project get(int id);

    List<Project> listProjectsByCategoryId(int categoryId);

    List<Project> listProjectsByCategoryType(String categoryType);
}
