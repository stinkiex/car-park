package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.CarDao;
import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultCarDao implements CarDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultCarDao.class);

    private static class SingletonHolder {
        static final CarDao HOLDER_INSTANCE = new DefaultCarDao();
    }

    public static CarDao getInstance() {
        return DefaultCarDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<Car> getCars() {
        final String sql = "SELECT * FROM car";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery(sql)){
            final List<Car> result = new ArrayList<>();
            while(resultSet.next()){
                Car car = new Car(
                        resultSet.getLong("carid"),
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getString("regnumber"),
                        resultSet.getInt("needforrepair")
                );
                result.add(car);
            }
            return result;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long save(Car car) {
        final String sql = "INSERT INTO car(name, model, regnumber, needforrepair) VALUES(?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, car.getName());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getRegNumber());
            ps.setInt(4, car.getNeedForRepair());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long deleteCar(Long id) {
        long flag = 0;
        final String sql = "DELETE FROM car WHERE carid = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            log.info("Car No: {} deleted", id);
        }catch (SQLException e){
            log.error("Fail to delete car No.:{}", id, e);
            throw new RuntimeException();
        }
        flag = 1;
        return flag;
    }

    @Override
    public long updateCar(Car car) {
        long flag = 0;
        final String sql = "UPDATE car SET name = ?, model = ?, regnumber = ?, needforrepair =? WHERE carid = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getRegNumber());
            preparedStatement.setInt(4, car.getNeedForRepair());
            preparedStatement.setLong(5, car.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            log.error("Failed update car No: {}", car.getRegNumber());
            throw new RuntimeException();
        }
        flag = 1;
        log.info("Car No: {} successful updated ", car.getRegNumber());
        return flag;
        }
}