// Заявка на рейс
package com.github.stinkiex.carpark.model;

public class FlightApplication {
    private long id;
    private String dateBeg;
    private String dateExp;
    private String cargo;
    private int weight;
    private String flightStatus;
    private String car;  //Todo связать с машинами;
    private String driver; //Todo connect with users

    public FlightApplication(long id, String dateBeg, String dateExp, String cargo, int weight, String flightStatus, String car, String driver) {
        this.id = id;
        this.dateBeg = dateBeg;
        this.dateExp = dateExp;
        this.cargo = cargo;
        this.weight = weight;
        this.flightStatus = flightStatus;
        this.car = car;
        this.driver = driver;
    }

    public long getId() {
        return id;
    }

    public String getDriver() {
        return driver;
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

    public int getWeight() {
        return weight;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public String getCar() {
        return car;
    }
}
