package com.dutianze.guide.greetRESTFul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: dutianze
 * Date: 2019-09-19
 */
@Slf4j
@Service
public class GreetingService {

    public String greet() {
        log.info("GreetingService:greet");
        return "Hello, %s!";
    }
}
