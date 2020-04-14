import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.impl.DefaultCarDao;
import com.github.stinkiex.carpark.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCarDaoTest {
    CarDao carDao = DefaultCarDao.getInstance();

    @Test
    @DisplayName("Not-null getCars Method Test")
    void getCars(){
        String name = "LADA";
        String model = "VESTA";
        String regnumber = "TT0001-9";
        int needforrepair = 0;
        carDao.save(new Car(null, name, model, regnumber, needforrepair));
        List<Car> list = carDao.getCars();
        Assertions.assertNotNull(list);
    }

}
