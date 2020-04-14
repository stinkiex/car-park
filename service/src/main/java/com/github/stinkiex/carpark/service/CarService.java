package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.impl.DefaultCarDao;
import com.github.stinkiex.carpark.model.Car;

import java.util.List;

public interface CarService {
    public void addCar(String name, String model, String regNumber );

    public Long deleteCar(Car car);

    public List<Car> getCars();
}
