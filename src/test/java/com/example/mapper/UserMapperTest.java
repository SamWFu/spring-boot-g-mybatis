package com.example.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.User;

/**
 * @author fusw
 * @version V1.0
 * @Date 2017/3/14 15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;

	@Test
	public void selectByPrimaryKey() throws Exception {

		User user = userMapper.selectByPrimaryKey(2);
		System.out.println(user.getName());
	}

}