package com.github.stinkiex.carpark.model;

public class AuthUser {
    private String login;
    private String password;
    private Role role;
    private String userId;
    private Long id;


    public AuthUser(Long id, String login, String password, Role role, String userId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }
}
