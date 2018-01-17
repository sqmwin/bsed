package cn.bsed.mapper;

import cn.bsed.pojo.User;

import java.util.List;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
public interface UserMapper {
    int insert(User user);

    int deleteByPrimaryKey(Integer id);

    int update(User user);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);

    List<User> selectAll();
}
