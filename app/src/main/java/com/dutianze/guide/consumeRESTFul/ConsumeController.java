package com.dutianze.guide.consumeRESTFul;

import com.dutianze.guide.flux.GreetingWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: dutianze
 * Date: 2019-09-12
 */
@Slf4j
@RestController
@RequestMapping(path = "api")
public class ConsumeController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private GreetingWebClient greetingWebClient;

    @GetMapping(value = "consume")
    public Quote consume() {
        log.info("ConsumeController is called");
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info("getForObject, quote:{}", quote);
        log.info("flux:{}", greetingWebClient.getResult());
        return quote;
    }
}
