// Заявка на рейс
package com.github.stinkiex.carpark.model;

import java.sql.Date;

public class FlightApplication {
    private long id;
    private Date datebeg;
    private Date dateexp;
    private String cargo;
    private int weight;
    private String status;
    private String car;
    private String driver;

    public FlightApplication(Long id, String car, String driver, Date datebeg, Date dateexp, String cargo, int weight, String status) {
        this.id = id;
        this.datebeg = datebeg;
        this.dateexp = dateexp;
        this.cargo = cargo;
        this.weight = weight;
        this.status = status;
        this.car = car;
        this.driver = driver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatebeg() {
        return datebeg;
    }

    public void setDatebeg(Date datebeg) {
        this.datebeg = datebeg;
    }

    public Date getDateexp() {
        return dateexp;
    }

    public void setDateexp(Date dateexp) {
        this.dateexp = dateexp;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
