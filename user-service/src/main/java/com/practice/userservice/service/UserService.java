package com.practice.userservice.service;

import com.practice.userservice.entity.User;
import com.practice.userservice.model.Bike;
import com.practice.userservice.model.Car;


import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface UserService {

    List<User> getAll();

    User getUserById(int id);

    User save(User user);

    List<Car> getCars(int userId);

    List<Bike> getBikes(int userId);

    Car saveCar(int userId, Car car);

    Bike saveBike(int userId, Bike bike);

    Map<String, Object> getUserAndVehicles(int userId);
}
