package com.practice.carservice.controller;

import com.practice.carservice.entity.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarController {

    @GetMapping()
    ResponseEntity<List<Car>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Car> getById(@PathVariable("id") int id);

    @PostMapping()
    ResponseEntity<Car> save(@RequestBody Car car);

    @GetMapping("/byuser/{userid}")
    ResponseEntity<List<Car>> getByUserId(@PathVariable("userid") int userid);

}
