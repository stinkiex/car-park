package com.github.stinkiex.carpark.dao;

import com.github.stinkiex.carpark.model.RepairRequest;

import java.util.List;

public interface RepairRequestDao {

    List<RepairRequest> getList();

    Long save(RepairRequest repairRequest);

    long delete(RepairRequest repairRequest);

    long update(RepairRequest repairRequest);
}
