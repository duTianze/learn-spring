package com.dutianze.guide.asyncGithub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author: dutianze
 * Date: 2019-09-25
 */
@Configuration
@EnableAsync
public class AsyncMethodConfiguration {

    @Bean("githubExecutor")
    public Executor githubExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("githubExecutor-");
        executor.initialize();
        return executor;
    }
}
