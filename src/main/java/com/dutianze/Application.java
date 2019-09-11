package com.dutianze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * run Application:
 *  1. $ mvn spring-boot:run
 *  2. $ mvn clear package -> java -jar learn-spring-0.0.1-SNAPSHOT.jar
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
