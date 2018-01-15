package cn.bsed.service.impl;

import cn.bsed.mapper.ProfessionMapper;
import cn.bsed.pojo.Profession;
import cn.bsed.pojo.ProfessionExample;
import cn.bsed.service.ProfessionService;
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
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionMapper professionMapper;

    @Override
    public void add(Profession profession) {
        professionMapper.insert(profession);
    }

    @Override
    public void delete(int id) {
        professionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Profession profession) {
        professionMapper.updateByPrimaryKeySelective(profession);
    }

    @Override
    public Profession get(int id) {
        return professionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Profession> listAll() {
        return professionMapper.selectByExample(new ProfessionExample());
    }

}
