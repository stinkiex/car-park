package com.github.stinkiex.carpark.service.impl;
import com.github.stinkiex.carpark.dao.UserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultUserDao;
import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.User;
import com.github.stinkiex.carpark.service.UserService;

import java.util.List;

public class DefaultUserService implements UserService {

    private UserDao userDao = DefaultUserDao.getInstance();

    private static volatile UserService instance;

    public static UserService getInstance() {
        UserService localInstance = instance;
        if (localInstance == null) {
            synchronized (UserService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultUserService();
                }
            }
        }
        return localInstance;
    }


    public List<User> getMembers() {
        return userDao.getMembers();
    }


    public Long saveMember(User user) {
        return userDao.save(user);
    }
}
