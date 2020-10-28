package com.example.demo.service.Impl;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public void create(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> readAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllPostByPlace(String name) {
        return postRepository.findByName(name);
    }

    @Override
    public List<Post> getAllPostByLogin(String login) {
        return postRepository.findByLogin(login);
    }

    @Override
    public boolean update(Post post, int id) {
        if(postRepository.existsById(id)){
        post.setId(id);
        postRepository.save(post);
        return true;
    }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
