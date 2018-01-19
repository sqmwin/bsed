package cn.bsed.service.impl;

import cn.bsed.exception.user.ChangePasswordException;
import cn.bsed.exception.user.WrongUserInformationException;
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
    private final String EMPTY = "";
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
    public void updatePassword(int id, String password, String ensure) throws ChangePasswordException {
        final int min = 5;
        final int max = 16;
        boolean passwordIsEmpty = password == null || password.equals(EMPTY);
        boolean ensureIsEmpty = ensure == null || ensure.equals(EMPTY);
        //判断密码是否为空
        if (passwordIsEmpty && ensureIsEmpty) {
            throw new ChangePasswordException("密码不能为空");
        }
        if (!passwordIsEmpty && !ensureIsEmpty) {
            //判断两次密码是否相同
            if (!password.equals(ensure)) {
                throw new ChangePasswordException("两次密码要相同");
                //判断密码长度
            } else if (password.length() < min) {
                throw new ChangePasswordException("密码长度太短，密码长度为5-16位");
                //判断密码长度
            } else if (password.length() > max) {
                throw new ChangePasswordException("密码长度太长，密码长度为5-16位");
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                String oldPassword = user.getPassword();
                String newPassword = MD5Util.getMD5(password);
                if (oldPassword != null && newPassword != null) {
                    //判断密码是否与旧密码相同
                    if (newPassword.equals(oldPassword)) {
                        throw new ChangePasswordException("新密码不能与旧密码相同");
                    } else {
                        user.setPassword(newPassword);
                        userMapper.update(user);
                    }
                }
            }
        }
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
    public void login(User user) throws WrongUserInformationException {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || username.equals(EMPTY)) {
            throw new WrongUserInformationException("用户名不能为空");
        }
        if (password == null || password.equals(EMPTY)) {
            throw new WrongUserInformationException("密码不能为空");
        }
        String password2MD5Code = MD5Util.getMD5(password);
        List<User> users = userMapper.selectAll();
        for (User userInDataBase : users) {
            if (!(username.equals(userInDataBase.getUsername()) && password2MD5Code.equals(userInDataBase.getPassword()))) {
                throw new WrongUserInformationException("用户名或密码错误");
            }
        }
    }
}
