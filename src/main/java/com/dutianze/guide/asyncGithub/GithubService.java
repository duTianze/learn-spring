package com.dutianze.guide.asyncGithub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @author: dutianze
 * Date: 2019-09-25
 */
@Slf4j
@Service
public class GithubService {

    private final RestTemplate restTemplate;

    public GithubService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async("githubExecutor")
    public CompletableFuture<User> findUser(String user) throws Exception {
        log.info("findUser, user:{}", user);
        String url = String.format("https://api.github.com/users/%s",user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000l);
        log.info("results:{}", results);
        return CompletableFuture.completedFuture(results);
    }
}
