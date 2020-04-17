import com.github.stinkiex.carpark.dao.FlightApplicationDao;
import com.github.stinkiex.carpark.dao.impl.DefaultFlightApplicationDao;
import com.github.stinkiex.carpark.model.FlightApplication;
import com.github.stinkiex.carpark.model.FlightStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Date;
import java.util.List;

public class DefaultFlightApplicationTest {
    FlightApplication fl1 = new FlightApplication(null, "TestCar", "TestDriver", Date.valueOf("2020-01-15"), Date.valueOf("2020-03-17"), "Кокаин", 20600, String.valueOf(FlightStatus.COMPLETED));
    FlightApplication fl2 = new FlightApplication(null, "TestCar", "TestDriver", Date.valueOf("2020-01-05"), Date.valueOf("2020-03-17"), "Кокаин", 20600, String.valueOf(FlightStatus.COMPLETED));
    FlightApplicationDao flightApplicationDao = new DefaultFlightApplicationDao();

    @Test
    @DisplayName("Save test")
    public void saveMethod() {
        flightApplicationDao.save(fl1);
        List<FlightApplication> list = flightApplicationDao.getFlightApplications();
        Assert.assertEquals(fl1.getCargo(), list.get(list.size()-1).getCargo());
        Assert.assertEquals(fl1.getWeight(), list.get(list.size()-1).getWeight());
        Assert.assertNotNull(list.get(list.size()-1).getId());
        Assert.assertEquals(fl1.getDatebeg(), list.get(list.size()-1).getDatebeg());
    }

}


