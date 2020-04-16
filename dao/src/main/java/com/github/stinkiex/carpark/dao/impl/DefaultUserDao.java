package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.UserDao;
import com.github.stinkiex.carpark.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);

    private static class SingletonHolder {
        static final UserDao HOLDER_INSTANCE = new DefaultUserDao();
    }

    public static UserDao getInstance() {
        return DefaultUserDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public Long save(User user) {
        String sql = "insert into user(firstname, lastname, phone) values(?, ?, ?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.executeUpdate();
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                keys.next();
                log.info("User {} created: ", user.toString());
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            log.error("fail to save user:{}", user, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public long idByFirstNameAndlastName(String firstName, String lastName){
        long result = 0;
        String sql = "SELECT id FROM user WHERE firstname = '";
        sql += firstName;
        sql += "'AND lastname = ";
        sql += "'";
        sql += lastName;
        sql += "'";
        try (Connection connection = DataSource.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            log.error("Failed to save User {} {}", firstName, lastName);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<User> getMembers() {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
             ResultSet resultSet = preparedStatement.executeQuery()){
            final List<User> result = new ArrayList<>();
            while(resultSet.next()){
                final User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phoneNumber")
                );
                result.add(user);
            }
            log.info("User finded {}: ", result.toString());
            return result;
        } catch (SQLException e){
            log.error("Users not found {}");
            throw new RuntimeException();
        }
    }



    @Override
    public long deleteUser(User user) {
        long flag = 0;
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
            log.info("Deleted user with id: {}", user.getId());
    }catch (SQLException e){
        log.error("Fail to delete user:{}", user, e);
        throw new RuntimeException();
    }
        flag = 1;
        return flag;
    }

    @Override
    public long updateUser(User user) {
        long flag = 0;
        String sql = "UPDATE user SET firstname = ?, lastname = ?, phone = ?";
        sql += " WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            log.error("Failed update user: {}", user);
            throw new RuntimeException();
        }
        flag = 1;
        log.info("Succesful updated user: {}", user);
        return flag;
    }
}
