package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultCarDao implements CarDao {

    private static class SingletonHolder {
        static final CarDao HOLDER_INSTANCE = new DefaultCarDao();
    }

    public static CarDao getInstance() {
        return DefaultCarDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<Car> getCars() {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
             ResultSet resultSet = preparedStatement.executeQuery()){
            final List<Car> result = new ArrayList<>();
            while(resultSet.next()){
                final Car car = new Car(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getString("regnumber"),
                        resultSet.getInt("needforrepair")
                );
                result.add(car);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Long save(Car car) {
        final String sql = "insert into car(name, model, regnumber, needforrepair) values(?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(2, car.getName());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getRegNumber());
            ps.setInt(5, car.getNeedForRepair());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
