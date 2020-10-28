package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;

public interface PostService {

    void create(Post post);
    List<Post> readAll();
    List<Post> getAllPostByPlace(String name);
    List<Post> getAllPostByLogin(String login);
    boolean update(Post post,int id);
    boolean delete(int id);

}
