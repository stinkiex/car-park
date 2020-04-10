package com.github.stinkiex.carpark.dao;

import com.github.stinkiex.carpark.model.User;

import java.util.List;

public interface UserDao {
    List<User> getMembers();

    Long save(User user);
}
