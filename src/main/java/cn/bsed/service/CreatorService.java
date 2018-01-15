package cn.bsed.service;

import cn.bsed.pojo.Creator;

import java.util.List;

/**
 * @author SQM
 * @Description:
 * @date 2018/1/15
 * @version: 1.0
 */
public interface CreatorService {
    void add(Creator creator);

    void delete(int id);

    void update(Creator creator);

    Creator get(int id);

    List<Creator> listAll();
}
