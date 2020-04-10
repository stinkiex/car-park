// Заявка на рейс
package com.github.stinkiex.carpark.model;

public class FlightApplication {
    private String dateBeg;
    private String dateExp;
    private String cargo;
    private double weight;
    private String flightStatus;
    private String car;  //Todo связать с машинами;

    public FlightApplication(String dateBeg, String dateExp, String cargo, double weight, String flightStatus, String car) {
        this.dateBeg = dateBeg;
        this.dateExp = dateExp;
        this.cargo = cargo;
        this.weight = weight;
        this.flightStatus = flightStatus;
        this.car = car;
    }

    public String getDateBeg() {
        return dateBeg;
    }

    public String getDateExp() {
        return dateExp;
    }

    public String getCargo() {
        return cargo;
    }

    public double getWeight() {
        return weight;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public String getCar() {
        return car;
    }
}
