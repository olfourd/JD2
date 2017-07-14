package by.itacademy.service;

import by.itacademy.entity.User;
import by.itacademy.entity.other.UserRole;
import by.itacademy.service.common.BaseServiseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class UserServiceTest extends BaseServiseTest{

    @Autowired
    private UserService userService;

    @Test
    public void getByLogin() throws Exception {
        String login = "Olfourd";
        User user = userService.getByLogin(login);
        assertEquals(user.getName(), login);
    }

    @Test
    public void createDelete() throws Exception {
        String name = "Asdfg";
        User user = new User(name, name);
        User savedUser = userService.create(user);
        assertEquals(savedUser.getName(), name);

        assertTrue(userService.delete(savedUser));
    }

    @Test
    public void getById() throws Exception {
        User user = userService.getById(2L);
        assertNotNull(user);
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

}