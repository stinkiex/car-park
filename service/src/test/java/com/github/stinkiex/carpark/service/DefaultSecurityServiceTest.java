package com.github.stinkiex.carpark.service;

import com.github.stinkiex.carpark.dao.AuthUserDao;
import com.github.stinkiex.carpark.model.AuthUser;
import com.github.stinkiex.carpark.service.impl.DefaultSecurityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultSecurityServiceTest {
    @Mock
    AuthUserDao dao;

    @InjectMocks
    DefaultSecurityService service;

    @Test
    void testLoginNotExist() {
        when(dao.getByLogin("admin")).thenReturn(null);
        AuthUser login = service.login("admin", "admin");
        assertNull(login);
    }

    @Test
    void testLoginCorrect() {
        when(dao.getByLogin("admin")).thenReturn(new AuthUser(null, "admin", "pass", null, null));
        AuthUser userFromDb = service.login("admin", "pass");
        assertNotNull(userFromDb);
        assertEquals(userFromDb.getLogin(), "admin");
        assertNotNull(userFromDb.getPassword(), "pass");
    }

    @Test
    void testLoginWrongPass() {
        when(dao.getByLogin("admin")).thenReturn(new AuthUser(null, "admin", "pass", null, null));
        AuthUser login = service.login("admin", "pass2");
        assertNull(login);
    }
}
