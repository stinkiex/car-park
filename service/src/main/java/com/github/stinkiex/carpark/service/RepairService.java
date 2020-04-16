package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.model.RepairRequest;
import com.github.stinkiex.carpark.model.RepairStatus;

import java.util.List;

public interface RepairService {
    public long saveRepair(String name, String number, String reason, RepairStatus status);

    public Long delete(RepairRequest repairRequest);

    public List<RepairRequest> getRepairs();

}
