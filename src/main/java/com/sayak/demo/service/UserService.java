package com.sayak.demo.service;

import com.sayak.demo.entity.User;
import com.sayak.demo.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
