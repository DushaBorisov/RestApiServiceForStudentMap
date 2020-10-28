package com.example.demo.service.Impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(String login) {
        if(userRepository.findByLogin(login) != null){
            return userRepository.findByLogin(login);
        }
        return null;
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User user = userRepository.findByLoginAndPassword(login, password);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public boolean update(User user, String login) {
        User lastUser = userRepository.findByLogin(login);
        if(lastUser != null ) {
            User newUser = user;
            newUser.setId(lastUser.getId());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String login) {
        User user = userRepository.findByLogin(login);
        if(user != null){
            int id = user.getId();
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
