package com.github.stinkiex.carpark.dao.impl;

import com.github.stinkiex.carpark.dao.DataSource;
import com.github.stinkiex.carpark.dao.RepairRequestDao;
import com.github.stinkiex.carpark.model.RepairRequest;
import com.github.stinkiex.carpark.model.RepairStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultRepairRequestDao implements RepairRequestDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);

    private static class SingletonHolder {
        static final RepairRequestDao HOLDER_INSTANCE = new DefaultRepairRequestDao();
    }

    public static RepairRequestDao getInstance() {
        return DefaultRepairRequestDao.SingletonHolder.HOLDER_INSTANCE;
    }


    @Override
    public Long save(RepairRequest repairRequest) {
        String sql = "insert into repair_request(car_name, reg_number, reason, status) values(?, ?, ?, ?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, repairRequest.getCarName());
            preparedStatement.setString(2, repairRequest.getCarNumber());
            preparedStatement.setString(3, repairRequest.getRepairReason());
            preparedStatement.setString(4, String.valueOf(RepairStatus.SENT));
            preparedStatement.executeUpdate();
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                keys.next();
                log.info("User {} created: ", repairRequest.toString());
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            log.error("fail to add Repair request for :{}", repairRequest.getCarName(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RepairRequest> getList() {
        RepairStatus repairStatus = null;
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
             ResultSet resultSet = preparedStatement.executeQuery()){
            final List<RepairRequest> result = new ArrayList<>();
            while(resultSet.next()){
                final RepairRequest repairRequest = new RepairRequest(
                        resultSet.getLong("id"),
                        resultSet.getString("car_name"),
                        resultSet.getString("reg_number"),
                        resultSet.getString("reason"),
                        repairStatus.valueOf(resultSet.getString("status"))
                );
                result.add(repairRequest);
            }
            log.info("User finded {}: ", result.toString());
            return result;
        } catch (SQLException e){
            log.error("Users not found {}");
            throw new RuntimeException();
        }
    }



    @Override
    public long delete(RepairRequest repairRequest) {
        long flag = 0;
        String sql = "DELETE FROM user WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, repairRequest.getId());
            preparedStatement.executeUpdate(sql);
            log.info("Deleted user with id: {}", repairRequest.getId());
        }catch (SQLException e){
            log.error("Fail to delete user:{}", repairRequest.getId(), e);
            throw new RuntimeException();
        }
        flag = 1;
        return flag;
    }

    @Override
    public long update(RepairRequest repairRequest) {
        long flag = 0;
        String sql = "UPDATE repair_request SET car_name = ?, reg_number = ?, reason = ?, status = ? WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, repairRequest.getCarName());
            preparedStatement.setString(2, repairRequest.getCarNumber());
            preparedStatement.setString(3, repairRequest.getRepairReason());
            preparedStatement.setString(4, String.valueOf(RepairStatus.SENT));
            preparedStatement.setLong(5, repairRequest.getId());
            preparedStatement.executeUpdate(sql);
        }catch (SQLException e){
            log.error("Failed update Repair Request #: {}", repairRequest.getId());
            throw new RuntimeException();
        }
        flag = 1;
        log.info("Repair Request # {} succesful updated ", repairRequest.getId());
        return flag;
    }
}
