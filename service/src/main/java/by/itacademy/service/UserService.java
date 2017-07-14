package by.itacademy.service;

import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {

    List<Topic> getCreatedTopicsById(Long primaryKey);

    List<RoleOfUser> getAllRolles(Long primaryKey);

    User getByLogin(String login);
}
