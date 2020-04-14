import com.github.stinkiex.carpark.dao.UserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultUserDao;
import com.github.stinkiex.carpark.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class DefaultUserDaoTest {
    User user1 = new User(null, "Александр", "Лукашенко", "+375114567890");
    User user2 = new User(null, "Владимир", "Путин", "+79991112233");

    @Test
    @DisplayName("saveUser test")
    public void saveUser(){
        UserDao userDao = new DefaultUserDao();
        userDao.save(user1);
        Assert.assertEquals("Александр", user1.getFirstName());
        //todo Запилить тест


    }

    @Test
    @DisplayName("idByFirstNameAndlastName")
    public void idByFirstNameAndlastName(){
        //todo        ;
    }
}
