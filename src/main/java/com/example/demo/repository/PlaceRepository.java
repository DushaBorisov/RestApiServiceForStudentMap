package com.example.demo.repository;

import com.example.demo.model.Place;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    @Query("select b from Place b where b.name = :name ")
    Place findByName(@Param("name") String name);
}
