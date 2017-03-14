package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.IUserService;

/**
 * @author fusw
 * @version V1.0
 * @Date 2017/3/14 15:47
 */
@Service("userService")
public class UserService implements IUserService {

	private final UserMapper userMapper;

	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<User> listUser() {

		return userMapper.listAll();
	}

	@Override
	public void saveUser(User user) {

		userMapper.insertSelective(user);
	}

	@Override
	public void delUser(int id) {

		userMapper.deleteByPrimaryKey(id);
	}
}
