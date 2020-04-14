package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.AuthUserDao;
import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DefaultAuthUserDao implements AuthUserDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class SingletonHolder {
        static final AuthUserDao HOLDER_INSTANCE = new DefaultAuthUserDao();
    }

    public static AuthUserDao getInstance() {
        return DefaultAuthUserDao.SingletonHolder.HOLDER_INSTANCE;
    }

    public AuthUser getByLogin(String login) {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from auth_user where login = ?")) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new AuthUser(
                            resultSet.getLong("id"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            Role.valueOf(resultSet.getString("role")),
                            resultSet.getLong("userid"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            log.error("User {} not found", login);
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        AuthUser authUser = new AuthUser(null, "login3", "pass", Role.DRIVER, 5L);
//        long val = DefaultAuthUserDao.getInstance().saveAuthUser(authUser);
//        System.out.println(val);
//    }

    public long saveAuthUser(AuthUser user) {
        final String sql = "insert into auth_user(login, password, role, userid) values(?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().name());
            ps.setLong(4, user.getUserId());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                generatedKeys.next();
                log.info("Auth user created: {}", user);
                return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            log.error("Failed creat user: {}", user);
            throw new RuntimeException(e);
        }//todo Разобраться с синзронным (User + Auth) созданием
    }

    @Override
    public long deleteAuthUser(int id) {
        long flag = 0;
        String sql = "DELETE * FROM auth_user WHERE userId = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            log.info("Deleted Authuser with id: {}", id);
        }catch (SQLException e){
            log.error("Fail to delete user with userid :{}", id, e);
            throw new RuntimeException(e);
        }
        flag = 1;
        return flag;
    }

    @Override
    public long checkExistUser(String login){
        long result = -10;
        String sql = "SELECT id FROM auth_user WHERE login='?' ";
        try(Connection connection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getLong("id");
            } return result;
        }catch (SQLException e) {
            log.error("User with login {} not Found", login);
            throw new RuntimeException(e);
        }
    }
}
