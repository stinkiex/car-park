package com.github.stinkiex.carpark.service.impl;

import com.github.stinkiex.carpark.dao.RepairRequestDao;
import com.github.stinkiex.carpark.dao.impl.DefaultRepairRequestDao;
import com.github.stinkiex.carpark.model.RepairRequest;
import com.github.stinkiex.carpark.model.RepairStatus;
import com.github.stinkiex.carpark.service.RepairService;

import java.util.List;

public class DefaultRepairService implements RepairService {

    private RepairRequestDao repairRequestDao = DefaultRepairRequestDao.getInstance();

    private static volatile RepairService instance;

    public static RepairService getInstance() {
        RepairService localInstance = instance;
        if (localInstance == null) {
            synchronized (RepairService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultRepairService();
                }
            }
        }
        return localInstance;
    }


    public long saveRepair(String name, String number, String reason, RepairStatus status) {
        RepairRequest repairRequest = new RepairRequest(null, name, number, reason, RepairStatus.SENT.toString());
        long flag = repairRequestDao.save(repairRequest);
        return flag;
    }

    public Long delete(RepairRequest repairRequest) {
        Long flag = repairRequestDao.delete(repairRequest);
        return flag;
    }

    public List<RepairRequest> getRepairs() {
        return repairRequestDao.getList();
    }
}
