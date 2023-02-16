package com.practice.carservice.service;

import com.practice.carservice.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getCarById(int id);

    Car save(Car car);

    List<Car> byUserId(int id);
}
