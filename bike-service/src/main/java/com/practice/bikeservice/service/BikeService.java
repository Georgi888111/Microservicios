package com.practice.bikeservice.service;

import com.practice.bikeservice.entity.Bike;

import java.util.List;

public interface BikeService {
    List<Bike> getAll();

    Bike getBikeById(int id);

    Bike save(Bike bike);

    List<Bike> byUserId(int id);
}
