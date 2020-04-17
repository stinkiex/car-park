package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.dao.CarDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DefaultCarServiceTest {

    @Mock
    CarDao carDao;

    @InjectMocks
    CarService service;

    @Test()
    public void getCars(){



    }
}
