package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.FlightApplicationDao;
import com.github.stinkiex.carpark.model.FlightApplication;
import com.github.stinkiex.carpark.model.FlightStatus;
import com.github.stinkiex.carpark.model.RepairStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultFlightApplicationDao implements FlightApplicationDao {

    private static final Logger log = LoggerFactory.getLogger(DefaultFlightApplicationDao.class);

    private static class SingletonHolder {
        static final FlightApplicationDao HOLDER_INSTANCE = new DefaultFlightApplicationDao();
    }

    public static FlightApplicationDao getInstance() {
        return DefaultFlightApplicationDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public List<FlightApplication> getFlightApplications() {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from flightapplication");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            final List<FlightApplication> result = new ArrayList<>();
            while (resultSet.next()) {
                final FlightApplication flightApplication = new FlightApplication(
                        resultSet.getLong("id"),
                        resultSet.getString("driver"),
                        resultSet.getString("car"),
                        resultSet.getDate("datebegin"),
                        resultSet.getDate("dateexp"),
                        resultSet.getString("cargo"),
                        resultSet.getInt("weight"),
                        resultSet.getString("flightstatus"));
                result.add(flightApplication);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long save(FlightApplication flightApplication) {
        final String sql = "insert into flightapplication(driver, car, datebegin, dateexp, cargo, weight, flightstatus) values(?,?,?,?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, flightApplication.getDriver());
            ps.setString(2, flightApplication.getCar());
            ps.setDate(3, flightApplication.getDatebeg());
            ps.setDate(4, flightApplication.getDateexp());
            ps.setString(5, flightApplication.getCargo());
            ps.setInt(6, flightApplication.getWeight());
            ps.setString(7, flightApplication.getStatus());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long update(FlightApplication flightApplication) {
        long flag = 0;
        String sql = "UPDATE flightapplication SET driver = ?, car = ?, datebegin = ?, dateexp = ?, cargo = ?, weight = ?, flightstatus = ?";
        sql += " WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, flightApplication.getDriver());
            ps.setString(2, flightApplication.getCar());
            ps.setDate(3, flightApplication.getDatebeg());
            ps.setDate(4, flightApplication.getDateexp());
            ps.setString(5, flightApplication.getCargo());
            ps.setInt(6, flightApplication.getWeight());
            ps.setString(7, String.valueOf(flightApplication.getStatus()));
            ps.executeUpdate();
        }catch (SQLException e){
            log.error("Failed update рейс номер: {}", flightApplication.toString());
            throw new RuntimeException(e);
        }
        flag = 1;
        log.info("Succesful updated рейс номер: {}", flightApplication.toString());
        return flag;
    }

    @Override
    public long delete(FlightApplication flightApplication) {
        long flag = 0;
        String sql = "DELETE FROM flightapplication WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, flightApplication.getId());
            preparedStatement.executeUpdate();
            log.info("Рейс № {} удалён успешно", flightApplication.getId());
        }catch (SQLException e){
            log.error("Ошибка при удалении рейса №:{}", flightApplication.getId(), e);
            throw new RuntimeException(e);
        }
        flag = 1;
        return flag;
    }
}
