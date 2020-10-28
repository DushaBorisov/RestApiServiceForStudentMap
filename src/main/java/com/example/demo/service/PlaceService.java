package com.example.demo.service;

import com.example.demo.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> readAll();
    Place findPlaceByName(String name);
    void create(Place place);
    boolean update(Place place, String name);
}
