package com.practice.carservice.controller.impl;

import com.practice.carservice.controller.CarController;
import com.practice.carservice.entity.Car;
import com.practice.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarControllerImpl implements CarController {

    @Autowired
    private CarService carService;

    @Override
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = this.carService.getAll();
        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
    }

    @Override
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        Car car = this.carService.getCarById(id);
        return car == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(car);
    }

    @Override
    public ResponseEntity<Car> save(Car car) {
        Car carNew = this.carService.save(car);
        return ResponseEntity.ok(carNew);
    }

    @Override
    public ResponseEntity<List<Car>> getByUserId(int userid) {
        List<Car> cars = carService.byUserId(userid);
        return ResponseEntity.ok(cars);
    }


}
