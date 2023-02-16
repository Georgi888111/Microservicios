package com.practice.userservice.controller;

import com.practice.userservice.entity.User;
import com.practice.userservice.model.Bike;
import com.practice.userservice.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


public interface UserController {

    @GetMapping()
    ResponseEntity<List<User>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<User> getById(@PathVariable("id") int id);

    @PostMapping()
    ResponseEntity<User> save(@RequestBody User user);

    @GetMapping("/cars/{userId}")
    ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId);

    @GetMapping("/bikes/{userId}")
    ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") int userId);

    @PostMapping("/savecar/{userId}")
    ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car);

    @PostMapping("/savebike/{userId}")
    ResponseEntity<Bike> saveBike(@PathVariable("userId") int userId, @RequestBody Bike bike);

    @GetMapping("/getAll/{userId}")
    ResponseEntity<Map<String,Object>> getUserAndVehicles(@PathVariable("userId") int userId);

}


