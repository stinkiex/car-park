package com.github.stinkiex.carpark.model;

public class Car {
    private Long carId;
    private String name;
    private String model;
    private String regNumber;
    private int needForRepair;

    public Car(Long carId, String name, String model, String regNumber, int needForRepair) {
        this.carId = carId;
        this.name = name;
        this.model = model;
        this.regNumber = regNumber;
        this.needForRepair = needForRepair;
    }

    public Long getCarId() {
        return carId;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getNeedForRepair() {
        return needForRepair;
    }
}
