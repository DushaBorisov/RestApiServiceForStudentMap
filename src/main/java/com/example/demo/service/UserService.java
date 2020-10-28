package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    void create(User user);
    List<User> readAll();
    User read(String login);
    User findUserByLoginAndPassword(String login, String password);
    boolean update(User user, String login);
    boolean delete(String login);

}
