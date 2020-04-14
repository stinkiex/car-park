package com.github.stinkiex.carpark.service.impl;

import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.UserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultCarDao;
import com.github.stinkiex.carpark.model.Car;
import com.github.stinkiex.carpark.model.User;
import com.github.stinkiex.carpark.service.CarService;

import java.util.List;

public class DefaultCarService implements CarService {

    CarDao carDao = DefaultCarDao.getInstance();

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

    public Long deleteCar(Car car){
        CarDao carDao = DefaultCarDao.getInstance();
        Long flag = carDao.deleteCar(car.getCarId());
        return flag;
    }

    public List<Car> getCars() {
        return carDao.getCars();
    }


}
