package com.practice.bikeservice.service.impl;

import com.practice.bikeservice.entity.Bike;
import com.practice.bikeservice.repository.BikeRepository;
import com.practice.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Bike> getAll() {
        return this.bikeRepository.findAll();
    }

    @Override
    public Bike getBikeById(int id) {
        return this.bikeRepository.findById(id).orElse(null);
    }

    @Override
    public Bike save(Bike bike) {
        Bike bikeNew = this.bikeRepository.save(bike);
        return bikeNew;
    }

    @Override
    public List<Bike> byUserId(int userId) {
        return bikeRepository.findByUserId(userId);
    }
}
