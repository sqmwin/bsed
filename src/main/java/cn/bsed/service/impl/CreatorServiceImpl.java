package cn.bsed.service.impl;

import cn.bsed.mapper.CreatorMapper;
import cn.bsed.pojo.Creator;
import cn.bsed.pojo.CreatorExample;
import cn.bsed.service.CreatorService;
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
public class CreatorServiceImpl implements CreatorService {
    @Autowired
    CreatorMapper creatorMapper;

    @Override
    public void add(Creator creator) {
        creatorMapper.insert(creator);
    }

    @Override
    public void delete(int id) {
        creatorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Creator creator) {
        creatorMapper.updateByPrimaryKeySelective(creator);
    }

    @Override
    public Creator get(int id) {
        return creatorMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Creator> listAll() {
        return creatorMapper.selectByExample(new CreatorExample());
    }

}
