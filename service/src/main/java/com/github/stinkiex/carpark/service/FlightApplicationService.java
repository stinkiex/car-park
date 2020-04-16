package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.model.FlightApplication;

import java.sql.Date;
import java.util.List;

public interface FlightApplicationService {

    List<FlightApplication> getList();

    Long save(String driver, String car, Date dateBegin, Date dateEnd, String cargo, int weight);

    long delete(FlightApplication flightApplication);

    long update(FlightApplication flightApplication);
}
