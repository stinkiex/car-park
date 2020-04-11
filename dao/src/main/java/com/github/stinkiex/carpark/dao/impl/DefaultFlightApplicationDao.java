package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.FlightApplicationDao;
import com.github.stinkiex.carpark.model.FlightApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultFlightApplicationDao implements FlightApplicationDao {

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
                        resultSet.getInt("id"),
                        resultSet.getString("datebegin"),
                        resultSet.getString("dateexp"),
                        resultSet.getString("cargo"),
                        resultSet.getInt("weight"),
                        resultSet.getString("flightstatus"),
                        resultSet.getString("car"),
                        resultSet.getString("driver")
                );
                result.add(flightApplication);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Long save(FlightApplication flightApplication) {
        final String sql = "insert into flightapplication(driver, car, datebegin, dateexp, cargo, weight, flightstatus) values(?,?,?,?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(2, flightApplication.getDriver());
            ps.setString(3, flightApplication.getCar());
            ps.setString(4, flightApplication.getDateBeg());
            ps.setString(5, flightApplication.getDateExp());
            ps.setString(6, flightApplication.getCargo());
            ps.setInt(7, flightApplication.getWeight());
            ps.setString(8, flightApplication.getFlightStatus());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FlightApplication flightApplication) {
        //todo

    }

    @Override
    public void delete(FlightApplication flightApplication) {
        //todo
    }
}
