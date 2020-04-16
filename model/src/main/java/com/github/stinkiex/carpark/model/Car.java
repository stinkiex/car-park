package com.github.stinkiex.carpark.model;

public class Car {
    private Long id;
    private String name;
    private String model;
    private String regNumber;
    private int needForRepair;

    public Car(){

    }

    public Car(Long id, String name, String model, String regNumber, int needForRepair) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.regNumber = regNumber;
        this.needForRepair = needForRepair;
    }

    public Long id() {
        return id;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setRepair(int needForRepair) {
        this.needForRepair = needForRepair;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + id +
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
                id.equals(car.id) &&
                name.equals(car.name) &&
                model.equals(car.model) &&
                regNumber.equals(car.regNumber);
    }
}
