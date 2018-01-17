package cn.bsed.service;

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

    User get(int id);

    User getByUsername(String username);

    boolean login(User user);
}
