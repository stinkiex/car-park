import com.github.stinkiex.carpark.dao.AuthUserDao;
import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.impl.DefaultAuthUserDao;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DefaultAuthUserDaoTest {
final AuthUserDao defaultAuthUserDao = DefaultAuthUserDao.getInstance();

@Test
 void saveAuthUser(){

}

@Test
void getByLogin(){

}
@Test
void deleteAuthUser() {

}

}
