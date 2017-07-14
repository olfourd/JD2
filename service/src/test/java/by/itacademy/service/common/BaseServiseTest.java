package by.itacademy.service.common;

import by.itacademy.config.ConfigService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = ConfigService.class)
public class BaseServiseTest {
}
