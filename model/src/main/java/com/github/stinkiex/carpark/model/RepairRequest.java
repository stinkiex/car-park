package com.github.stinkiex.carpark.model;

public class RepairRequest {
    private long id;
    private String name;
    private String number;
    private String reason;
    private String status;

    public RepairRequest(Long id, String name, String number, String reason, String status) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.reason = reason;
        this.status = status;
    }

    public RepairRequest(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RepairRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
