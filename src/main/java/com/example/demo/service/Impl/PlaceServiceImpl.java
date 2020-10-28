package com.example.demo.service.Impl;

import com.example.demo.model.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    @Override
    public List<Place> readAll() {
        return placeRepository.findAll();
    }

    @Override
    public Place findPlaceByName(String name) {
       Place place =  placeRepository.findByName(name);
       if(place != null) {return place;}
       return null;
    }

    @Override
    public void create(Place place) {
        placeRepository.save(place);

    }

    @Override
    public boolean update(Place place, String name) {
        Place lastPlace = placeRepository.findByName(name);
        if(lastPlace != null){
            Place newPlace = place;
            newPlace.setId(lastPlace.getId());
            placeRepository.save(newPlace);
            return true;
        }
        return false;
    }
}
