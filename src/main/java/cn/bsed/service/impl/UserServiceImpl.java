package cn.bsed.service.impl;

import cn.bsed.mapper.UserMapper;
import cn.bsed.pojo.User;
import cn.bsed.service.UserService;
import cn.bsed.util.security.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
        String password = user.getPassword();
        String password2MD5Code = MD5Util.getMD5(password);
        user.setPassword(password2MD5Code);
        userMapper.insert(user);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        String password = user.getPassword();
        String password2MD5Code = MD5Util.getMD5(password);
        user.setPassword(password2MD5Code);
        userMapper.update(user);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String password2MD5Code = MD5Util.getMD5(password);
        List<User> users = userMapper.selectAll();
        for (User userInDataBase : users) {
            if (username.equals(userInDataBase.getUsername()) && password2MD5Code.equals(userInDataBase.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
