package com.dutianze.guide.RESTFul;

import lombok.extern.slf4j.Slf4j;
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

    private static final String template = "Hello, %s!";
    private final AtomicLong conter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")String name)  {
        log.info("greeting, name:{}", name);
        Greeting greeting = new Greeting(conter.incrementAndGet(), String.format(template, name));
        log.info("greeting:{}", greeting);
        return greeting;
    }
}
