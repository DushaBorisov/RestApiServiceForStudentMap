package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

   User findByLoginAndPassword(String login, String password);
   //boolean deleteByLogin(String login);

    @Query("select b from User b where b.login = :login ")
    User findByLogin(@Param("login") String login);

//    @Query("select b from User b where b.login = :login ")
//    boolean existByLogin(@Param("login") String login);

}
