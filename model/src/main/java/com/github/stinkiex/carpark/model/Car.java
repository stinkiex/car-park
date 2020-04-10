package com.github.stinkiex.carpark.model;

public class Car {
    private String name;
    private String model;
    private String regNumber;
    private String needForRepair;

    public Car(String name, String model, String regNumber, String needForRepair) {
        this.name = name;
        this.model = model;
        this.regNumber = regNumber;
        this.needForRepair = needForRepair;
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

    public String getNeedForRepair() {
        return needForRepair;
    }
}
