package com.dutianze.guide.asyncGithub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: dutianze
 * Date: 2019-09-25
 */
@Slf4j
@RestController
public class GithubController {

    @Autowired
    private GithubService githubService;

    @GetMapping(value = "/github")
    public List<User> github() throws Exception{
        log.info("github start ...");
        // start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = githubService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = githubService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = githubService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        log.info("--> " + page1.get());
        log.info("--> " + page2.get());
        log.info("--> " + page3.get());

        List<User> list = Arrays.asList(page1.get(), page2.get(), page3.get());
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("github end ...");
        return list;
    }
}
