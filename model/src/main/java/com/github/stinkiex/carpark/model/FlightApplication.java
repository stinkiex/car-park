// Заявка на рейс
package com.github.stinkiex.carpark.model;

public class FlightApplication {
    private long id;
    private String dateBeg;
    private String dateExp;
    private String cargo;
    private int weight;
    private String flightStatus;
    private String car;
    private String driver;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setDateBeg(String dateBeg) {
        this.dateBeg = dateBeg;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "FlightApplication{" +
                "id=" + id +
                ", dateBeg='" + dateBeg + '\'' +
                ", dateExp='" + dateExp + '\'' +
                ", cargo='" + cargo + '\'' +
                ", weight=" + weight +
                ", flightStatus='" + flightStatus + '\'' +
                ", car='" + car + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
