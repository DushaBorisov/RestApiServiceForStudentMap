package com.example.demo.controllers;

import com.example.demo.model.Place;
import com.example.demo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }

    // Создание места
    @PostMapping(value = "/places")
    public ResponseEntity<?> create(@RequestBody Place place){
        placeService.create(place);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Список всех мест
    @GetMapping(value = "/places")
    public ResponseEntity<List<Place>> read(){
        final List<Place> places = placeService.readAll();

        return places != null && !places.isEmpty()
                ? new ResponseEntity<>(places, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить место по имени места
    @GetMapping(value = "/places/{name}")
    public ResponseEntity<Place> read(@PathVariable(name = "name") String name){
        final Place place = placeService.findPlaceByName(name);

        return place != null
                ? new ResponseEntity<>(place,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Обновить место
    @PutMapping(value ="/places/{name}")
     public ResponseEntity<?> update(@PathVariable(name = "name") String name,
                                         @RequestBody Place place){
        final boolean update = placeService.update(place,name);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
