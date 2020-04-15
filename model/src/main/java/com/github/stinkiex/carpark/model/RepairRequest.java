package com.github.stinkiex.carpark.model;

public class RepairRequest {
    private long id;
    private String carName;
    private String carNumber;
    private String repairReason;
    private RepairStatus repairStatus;

    public RepairRequest(long id, String carName, String carNumber, String repairReason, RepairStatus repairStatus) {
        this.id = id;
        this.carName = carName;
        this.carNumber = carNumber;
        this.repairReason = repairReason;
        this.repairStatus = repairStatus;
    }

    public long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getRepairReason() {
        return repairReason;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return "RepairRequest{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", repairReason='" + repairReason + '\'' +
                ", repairStatus=" + repairStatus +
                '}';
    }
}
