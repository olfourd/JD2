package by.itacademy.dao.classes;

import by.itacademy.config.ConfigDaoTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConfigDaoTest.class)
@Transactional
public class BaseDaoTest {

}
