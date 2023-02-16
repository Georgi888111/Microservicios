package com.practice.carservice.service.impl;

import com.practice.carservice.entity.Car;
import com.practice.carservice.repository.CarRepository;
import com.practice.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        return this.carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        Car carNew = this.carRepository.save(car);
        return carNew;
    }

    @Override
    public List<Car> byUserId(int userId) {
        return carRepository.findByUserId(userId);
    }
}
