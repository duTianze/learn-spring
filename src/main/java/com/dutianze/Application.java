package com.dutianze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * run Application:
 *  1. $ mvn spring-boot:run
 *  2. $ mvn clear package -> java -jar learn-spring-0.0.1-SNAPSHOT.jar
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
