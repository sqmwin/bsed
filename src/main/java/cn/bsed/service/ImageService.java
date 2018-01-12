package cn.bsed.service;

import cn.bsed.pojo.Image;

import java.util.List;

/**
 * @author SQM
 * @create 2018/1/11
 */
public interface ImageService {
    /**
     *<p> 增
     *@param image  增加的image
     */
    void add(Image image);

    /**
     *<p> 删
     *@param id 删除的image的id
     */
    void delete(int id);

    /**
     *<p> 通过id获取image
     *@param id 所要获取image的id
     *@return cn.bsed.pojo.Image    获取的image对象
     */
    Image get(int id);

    /**
     *<p> 获取所有image
     *@return java.util.List<cn.bsed.pojo.Image> image的list集合
     */
    List<Image> listAll();
}
