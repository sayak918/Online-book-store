package com.sayak.demo.dao;


import com.sayak.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
