package com.github.stinkiex.carpark.model;

public class Car {
    private Long carId;
    private String name;
    private String model;
    private String regNumber;
    private int needForRepair;

    public Car(){

    }

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

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setNeedForRepair(int needForRepair) {
        this.needForRepair = needForRepair;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", needForRepair=" + needForRepair +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return needForRepair == car.needForRepair &&
                carId.equals(car.carId) &&
                name.equals(car.name) &&
                model.equals(car.model) &&
                regNumber.equals(car.regNumber);
    }
}
