package cn.bsed.service;

import cn.bsed.pojo.Profession;

import java.util.List;

/**
 * @author SQM
 * @Description:
 * @date 2018/1/15
 * @version: 1.0
 */
public interface ProfessionService {
    void add(Profession profession);

    void delete(int id);

    void update(Profession profession);

    Profession get(int id);

    List<Profession> listAll();
}
