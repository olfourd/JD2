package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<Topic> getCreatedTopicsById(Long primaryKey);

    List<RoleOfUser> getAllRolles(Long primaryKey);

    User getByName(String login);

}
