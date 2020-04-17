package com.github.stinkiex.carpark.model;

public class Car {
    private Long id;
    private String name;
    private String model;
    private String regnumber;
    private int repair;

    public Car(){

    }

    public Car(Long id, String name, String model, String regnumber, int repair) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.regnumber = regnumber;
        this.repair = repair;
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

    public String getRegnumber() {
        return regnumber;
    }


    public int getRepair() {
        return repair;
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
        this.regnumber = regnumber;
    }

    public void setRepair(int needForRepair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", regnumber='" + regnumber + '\'' +
                ", repair=" + repair +
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
        return repair == car.repair &&
                id.equals(car.id) &&
                name.equals(car.name) &&
                model.equals(car.model) &&
                regnumber.equals(car.regnumber);
    }
}