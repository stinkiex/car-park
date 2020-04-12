package com.github.stinkiex.carpark.dao;

import com.github.stinkiex.carpark.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getCars();

    Long save(Car car);

    long deleteCar(Car car);

    long updateCar(Car car);
}
