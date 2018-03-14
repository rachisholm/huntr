package io.whiskyhuntr.core;

import com.netflix.config.ConfigurationManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
@SpringBootApplication
public class WhiskyHuntr {

    public static void main(String[] args) {

        //Load auth properties manually
        try {
            ConfigurationManager.loadCascadedPropertiesFromResources("auth");
        } catch (IOException e) {
            e.printStackTrace();
        }


        SpringApplication.run(WhiskyHuntr.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }

        };
    }
}
