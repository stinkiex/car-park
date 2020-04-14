package com.github.stinkiex.carpark.service.impl;

import com.github.stinkiex.carpark.service.FlightApplicationService;

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



}
