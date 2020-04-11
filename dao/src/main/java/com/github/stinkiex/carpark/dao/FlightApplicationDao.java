package com.github.stinkiex.carpark.dao;

import com.github.stinkiex.carpark.model.FlightApplication;

import java.util.List;

public interface FlightApplicationDao {
    List<FlightApplication> getFlightApplications();

    Long save(FlightApplication flightApplication);

    void update(FlightApplication flightApplication);

    void delete(FlightApplication flightApplication);


}
