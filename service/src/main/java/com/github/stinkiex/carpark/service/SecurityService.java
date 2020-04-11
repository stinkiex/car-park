package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.model.AuthUser;

public interface SecurityService {
    AuthUser login(String login, String password);
}
