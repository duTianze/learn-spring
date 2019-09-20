package com.dutianze.guide.greetRESTFul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author: dutianze
 * Date: 2019-09-05
 */
@Slf4j
@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greeting;

    @RequestMapping(value = "/greeting", method = GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name)  {
        log.info("GreetingController:greeting, name:{}", name);
        String template = greeting.greet();
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        return greeting;
    }
}
