package cn.bsed.service;

import cn.bsed.exception.user.ChangePasswordException;
import cn.bsed.exception.user.WrongUserInformationException;
import cn.bsed.pojo.User;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
public interface UserService {

    void add(User user);

    void delete(int id);

    void update(User user);

    void updatePassword(int id, String password, String ensure) throws ChangePasswordException;

    User get(int id);

    User getByUsername(String username);

    void login(User user) throws WrongUserInformationException;
}
