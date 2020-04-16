package com.github.stinkiex.carpark.service;


import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.model.User;

import java.util.List;

public interface UserService {
    List<User> getMembers();

    Long saveMember(User user);
}
