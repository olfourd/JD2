package by.itacademy.config;

import by.itacademy.aspect.MyLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public MyLogger logger(){
        return new MyLogger();
    }
}
