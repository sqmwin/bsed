package cn.bsed.service.impl;

import cn.bsed.mapper.ImageMapper;
import cn.bsed.pojo.Image;
import cn.bsed.pojo.ImageExample;
import cn.bsed.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *
 * @author SQM
 * @create 2018/1/11
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

    @Override
    public void add(Image image) {
        imageMapper.insert(image);
    }

    @Override
    public void delete(int id) {
        imageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Image get(int id) {
        return imageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Image> listAll() {
        ImageExample example = new ImageExample();
        example.setOrderByClause("id desc");
        return imageMapper.selectByExample(example);
    }
}
