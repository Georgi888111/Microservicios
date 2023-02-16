package com.practice.bikeservice.controller;

import com.practice.bikeservice.entity.Bike;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BikeController {

    @GetMapping()
    ResponseEntity<List<Bike>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Bike> getById(@PathVariable("id") int id);

    @PostMapping()
    ResponseEntity<Bike> save(@RequestBody Bike bike);

    @GetMapping("/byuser/{userid}")
    ResponseEntity<List<Bike>> getByUserId(@PathVariable("userid") int userid);
}
