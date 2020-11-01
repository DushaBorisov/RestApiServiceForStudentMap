package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    // Обрабатывает запросы для БД users
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping(value = "/work")
        String hello(){
            return "Hello world";
        }


    // Создание пользователя user
    @PostMapping(value="/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Получить все записи из таблицы users
    @GetMapping(value ="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        final List<User> users = userService.readAll();

        return users!= null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить пользователя по логину
    @GetMapping(value = "/users/{login}")
    public ResponseEntity<User> findUserByLogin(@PathVariable(name="login") String login){
        final User user = userService.read(login);

        return user != null
                ? new ResponseEntity<>(user,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить запись по логину и паролю
    @GetMapping(value = "/users/{login}/{password}")
    public ResponseEntity<User> findUserByLoginAndPassword(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password){
        final User user = userService.findUserByLoginAndPassword(login,password);

        return user != null
                ? new ResponseEntity<>(user,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /* Редактировать запись по логину, запись имеющаяся в БД, полностью заменяется
     на новый поставленный объект user.
    id записи остается тем же
     */
    @PutMapping(value = "/users/{login}")
    public ResponseEntity<?> uddateUserByLogin(
            @PathVariable(name="login") String login,
            @RequestBody User user) {
        final boolean update = userService.update(user,login);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Удаление записи по логину пользователя
    @DeleteMapping(value = "/users/{login}")
    public ResponseEntity<User> deleteUserByLogin(@PathVariable(name="login") String login){
        final boolean deleted = userService.delete(login);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
