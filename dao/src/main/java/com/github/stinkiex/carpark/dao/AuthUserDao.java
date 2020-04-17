package com.github.stinkiex.carpark.dao;

import com.github.stinkiex.carpark.model.AuthUser;

public interface AuthUserDao {
    AuthUser getByLogin(String login);

    long saveAuthUser(AuthUser user);

    long deleteAuthUser(int id);

    long checkExistUser(String login);
}
