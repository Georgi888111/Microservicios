package com.practice.userservice.controller.impl;

import com.practice.userservice.controller.UserController;
import com.practice.userservice.entity.User;
import com.practice.userservice.model.Bike;
import com.practice.userservice.model.Car;
import com.practice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userService.getAll();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = this.userService.getUserById(id);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> save(@RequestBody User user) {
        User userNew = this.userService.save(user);
        return ResponseEntity.ok(userNew);
    }

    @Override
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId) {

        User user = userService.getUserById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @Override
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") int userId) {

        User user = userService.getUserById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }

    @Override
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car){
        if(userService.getUserById(userId) == null)
            return ResponseEntity.notFound().build();
        Car carNew = userService.saveCar(userId,car);
        return ResponseEntity.ok(car);

    }

    @Override
    public ResponseEntity<Bike> saveBike(@PathVariable("userId") int userId, @RequestBody Bike bike) {
        if(userService.getUserById(userId) == null)
            return ResponseEntity.notFound().build();
        Bike bikeNew = userService.saveBike(userId,bike);
        return ResponseEntity.ok(bike);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getUserAndVehicles(@PathVariable("userId") int userId) {
      Map<String,Object> result = userService.getUserAndVehicles(userId);
      return ResponseEntity.ok(result);
    }
}
