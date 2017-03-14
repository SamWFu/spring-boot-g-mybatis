package com.example.service;

import com.example.model.User;

import java.util.List;

/**
 * @author fusw
 * @version V1.0
 * @Date 2017/3/14  15:47
 */
public interface IUserService {

    /**
     * 获取所有用户
     * @return 列出所有用户
     */
    List<User> listUser();

    /**
     * 保存用户
     * @param user 要保存的用户
     */
    void saveUser(User user);

    /**
     * 删除用户
     * @param id 要删除的用户的id
     */
    void delUser(int id);
}
