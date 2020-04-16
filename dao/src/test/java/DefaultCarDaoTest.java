import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.impl.DefaultCarDao;
import com.github.stinkiex.carpark.model.Car;
import org.junit.jupiter.api.*;
import java.util.List;

@DisplayName("CarDao Tests")
public class DefaultCarDaoTest {
    CarDao carDao = DefaultCarDao.getInstance();
    String name = "LADA";
    String model = "VESTA";
    String regnumber = "TT0001-9";
    int needforrepair = 0;


    @Test
    @DisplayName("Not-null getCars Method Test")
    void getCars(){
        carDao.save(new Car(null, name, model, regnumber, needforrepair));
        List<Car> list = carDao.getCars();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.get(list.size()-1).getModel(), model);
    }

    @Test
    @DisplayName("Equals in and out")
    void getCarsEquals(){
        carDao.save(new Car(null, name, model, regnumber, needforrepair));
        List<Car> list = carDao.getCars();
        Assertions.assertEquals(list.get(list.size()-1).getModel(), model);
        Assertions.assertEquals(list.get(list.size()-1).getName(), name);
        Assertions.assertEquals(list.get(list.size()-1).getRegnumber(), regnumber);
        Assertions.assertEquals(list.get(list.size()-1).getRepair(), needforrepair);
    }
}