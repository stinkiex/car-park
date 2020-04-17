package com.github.stinkiex.carpark.service.impl;

import com.github.stinkiex.carpark.dao.FlightApplicationDao;
import com.github.stinkiex.carpark.dao.impl.DefaultFlightApplicationDao;
import com.github.stinkiex.carpark.model.FlightApplication;
import com.github.stinkiex.carpark.model.FlightStatus;
import com.github.stinkiex.carpark.service.FlightApplicationService;

import java.sql.Date;
import java.util.List;

public class DefaultFlightApplicationService implements FlightApplicationService {

    private static volatile FlightApplicationService instance;

    public static FlightApplicationService getInstance() {
        FlightApplicationService localInstance = instance;
        if (localInstance == null) {
            synchronized (FlightApplicationService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultFlightApplicationService();
                }
            }
        }
        return localInstance;
    }

    FlightApplicationDao flightApplicationDao = DefaultFlightApplicationDao.getInstance();


    public List<FlightApplication> getList() {
        return flightApplicationDao.getFlightApplications();
    }

    public Long save(String driver, String car, Date dateBegin, Date dateEnd, String cargo, int weight) {
        FlightApplication flightApplication = new FlightApplication(null, driver, car, dateBegin, dateEnd, cargo, weight, String.valueOf(FlightStatus.WAIT));
        return flightApplicationDao.save(flightApplication);
    }

    public long delete(FlightApplication flightApplication) {
        return flightApplicationDao.delete(flightApplication);
    }

    public long update(FlightApplication flightApplication) {
        return flightApplicationDao.update(flightApplication);
    }
}
