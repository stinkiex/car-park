package com.github.stinkiex.carpark.service.impl;


import com.github.stinkiex.carpark.dao.AuthUserDao;
import com.github.stinkiex.carpark.dao.UserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultAuthUserDao;
import com.github.stinkiex.carpark.dao.impl.DefaultUserDao;
import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.Role;
import com.github.stinkiex.carpark.model.User;
import com.github.stinkiex.carpark.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSecurityService implements SecurityService {
    private static final Logger log = LoggerFactory.getLogger(DefaultSecurityService.class);
    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    private static volatile SecurityService instance;

    public static SecurityService getInstance() {
        SecurityService localInstance = instance;
        if (localInstance == null) {
            synchronized (SecurityService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultSecurityService();
                }
            }
        }
        return localInstance;
    }

    public AuthUser login(String login, String password) {
        AuthUser user = authUserDao.getByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            log.info("user {} loggined sucesful", login);
            return user;
        }
        log.error("Login failed: error {} or password", login);
        return null;
    }

    private static boolean checkAlreadyExistsUser(String login) {
        boolean flag = false;
        DefaultAuthUserDao defaultAuthUserDao = new DefaultAuthUserDao();
        if(login.equals(defaultAuthUserDao.getByLogin(login))) {
            flag = true;
        }
        return flag;
    }

    public AuthUser createUser(String login, String password){
        if (!checkAlreadyExistsUser(login)) {
            AuthUserDao authUserDao = new DefaultAuthUserDao();
            UserDao userDao = new DefaultUserDao();
            authUserDao.saveAuthUser(new AuthUser(null, login, password, Role.DRIVER, null));
            userDao.save(new User(authUserDao.getByLogin(login).getId(), null, null, null));
            log.info("User {} successful greated", login);
        }
        return null;
    }
}
