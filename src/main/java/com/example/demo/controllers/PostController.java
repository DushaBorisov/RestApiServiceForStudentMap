package com.example.demo.controllers;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    // Создание нового поста
    @PostMapping(value = "/posts")
    public ResponseEntity<?> create(@RequestBody Post post){
        postService.create(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Получить все имеющиеся в БД посты
    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> read(){
        final List<Post> posts = postService.readAll();

        return posts != null && !posts.isEmpty()
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить все посты с указанным местом
    @GetMapping(value = "/posts/name/{name}")
    public ResponseEntity<List<Post>> findAllPostByPlace(@PathVariable(name = "name") String name){
        final List<Post> posts= postService.getAllPostByPlace(name);

        return (posts != null && !posts.isEmpty())
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить все посты с указанным логином
    @GetMapping(value = "/posts/login/{login}")
    public ResponseEntity<List<Post>> findAllPostByLogin(@PathVariable(name = "login") String login){
        final List<Post> posts= postService.getAllPostByLogin(login);

        return (posts != null && !posts.isEmpty())
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value ="/posts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,
                                    @RequestBody Post post){
        final boolean update = postService.update(post,id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean delete = postService.delete(id);

        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
