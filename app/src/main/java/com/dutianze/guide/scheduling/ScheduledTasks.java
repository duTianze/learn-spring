package com.dutianze.guide.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dutianze
 * Date: 2019-09-11
 */
@Slf4j
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 100000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dataFormat.format(new Date()));
    }
}
