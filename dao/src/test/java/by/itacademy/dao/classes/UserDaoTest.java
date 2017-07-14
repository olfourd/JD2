package by.itacademy.dao.classes;

import by.itacademy.dao.UserDao;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.entity.other.UserRole;
import by.itacademy.util.TestDataImporte;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;


public class UserDaoTest extends BaseDaoTest{

    @Autowired
    private UserDao userDao;
    @Autowired
    private TestDataImporte dataImport;

    @Before
    public void init(){
        dataImport.importTestData(userDao.getSessionFactory().getCurrentSession());
    }
    @Test
    public void getByLogin() {
        String login = "Qwerty";
        User user = userDao.getByName(login);
        assertEquals(user.getName(), login);
    }

    @Test
    public void saveGetById() {
        String name = "Hamlo";
        User user = new User(name, name);
        User savedUser = userDao.save(user);
        assertEquals(savedUser.getName(), name);
        assertEquals(savedUser.getPassword(), name);

        long id = savedUser.getId();
        User getUserById = userDao.getById(id);
        assertEquals(savedUser.getName(), getUserById.getName());
        assertEquals(savedUser.getPassword(), getUserById.getPassword());
    }

    @Test
    public void updateDelete() throws Exception {
        String name = "Archer";
        User user = new User(name, name);
        userDao.save(user);
        User updatedUser = userDao.update(user);

        boolean resultDelete = userDao.delete(updatedUser);
        assertTrue(resultDelete);
    }

    @Test
    public void getAll() throws Exception {
        List<User> result = userDao.getAll();
        List<String> loginsOfUsers = result.stream().map(User::getName).collect(toList());
        assertThat(loginsOfUsers, contains("Qwerty", "Olfourd", "DeGriz"));
    }

    @Test
    public void getCreatedTopicsById() throws Exception {
        User user = userDao.getByName("DeGriz");
        List<Topic> topics = userDao.getCreatedTopicsById(user.getId());
        assertThat(topics, hasSize(1));
        List<String> namesOfTopics = topics.stream().map(Topic::getName).collect(toList());
        assertThat(namesOfTopics, contains("simple topic"));
    }

    @Test
    public void getAllRolles() throws Exception {
        User user = userDao.getByName("Olfourd");
        List<RoleOfUser> rolles = userDao.getAllRolles(user.getId());
        List<UserRole> collect = rolles.stream().map(RoleOfUser::getRole).collect(toList());
        assertTrue(collect.contains(UserRole.ADMIN));
        assertTrue(collect.contains(UserRole.USER));
    }
}