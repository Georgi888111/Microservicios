package com.practice.bikeservice.controller.impl;

import com.practice.bikeservice.controller.BikeController;
import com.practice.bikeservice.entity.Bike;
import com.practice.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeControllerImpl implements BikeController {

    @Autowired
    private BikeService bikeService;

    @Override
    public ResponseEntity<List<Bike>> getAll() {
        List<Bike> bikes = this.bikeService.getAll();
        return bikes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bikes);
    }

    @Override
    public ResponseEntity<Bike> getById(int id) {
        Bike bike = this.bikeService.getBikeById(id);
        return bike == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(bike);
    }

    @Override
    public ResponseEntity<Bike> save(Bike bike) {
        Bike bikeNew = this.bikeService.save(bike);
        return ResponseEntity.ok(bikeNew);
    }

    @Override
    public ResponseEntity<List<Bike>> getByUserId(int userid) {
        List<Bike> bikes = bikeService.byUserId(userid);
        return ResponseEntity.ok(bikes);
    }
}
