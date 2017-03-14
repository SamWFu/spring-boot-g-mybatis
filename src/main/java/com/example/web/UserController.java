package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.IUserService;

/**
 * @author fusw
 * @version V1.0
 * @Date 2017/1/1816:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private final IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listUser(Model model) {

		List<User> users = userService.listUser();
		if (!CollectionUtils.isEmpty(users)) {

			model.addAttribute("users", users);
		}
		return "userList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(User user) {

		user.setId(0);
		userService.saveUser(user);
		return "redirect:/user";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String delUser(int id) {

		userService.delUser(id);
		return "redirect:/user";
	}
}
