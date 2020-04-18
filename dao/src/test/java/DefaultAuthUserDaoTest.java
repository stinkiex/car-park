import com.github.stinkiex.carpark.dao.AuthUserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultAuthUserDao;
import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.Role;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DefaultAuthUserDaoTest {
final AuthUserDao defaultAuthUserDao = DefaultAuthUserDao.getInstance();

@Test
 public void saveAuthUser(){

}

@Test
public void getByLogin(){

}
@Test
public void deleteAuthUser() {

}

 @Test
 @DisplayName("checkExistUser method Test")
 public void checkExistUser(){
 String login = "testUser";
 String pass = "testPass";
 defaultAuthUserDao.saveAuthUser(new AuthUser(null, login, pass, Role.BLOCKED, null));
 Assertions.assertEquals(defaultAuthUserDao.checkExistUser(login), 1);
 }

}
