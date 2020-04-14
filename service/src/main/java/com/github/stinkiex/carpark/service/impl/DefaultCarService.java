package com.github.stinkiex.carpark.service.impl;

import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.impl.DefaultCarDao;
import com.github.stinkiex.carpark.model.Car;
import com.github.stinkiex.carpark.service.CarService;

public class DefaultCarService implements CarService {

    private static volatile CarService instance;

    public static CarService getInstance() {
        CarService localInstance = instance;
        if (localInstance == null) {
            synchronized (CarService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultCarService();
                }
            }
        }
        return localInstance;
    }

    public void addCar(String name, String model, String regNumber ){
        Car car = new Car(null, name,model, regNumber, 0);
        CarDao carDao = DefaultCarDao.getInstance();
        carDao.save(car);
    }

    public void deleteCar(String name, String model, String regNumber ){
        Car car = new Car(null, name,model, regNumber, 0);
        CarDao carDao = DefaultCarDao.getInstance();
        carDao.deleteCar(car.getCarId());
    }


}
