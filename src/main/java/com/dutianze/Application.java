package com.dutianze;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * run Application:
 *  1. $ mvn spring-boot:run
 *  2. $ mvn clear package -> java -jar learn-spring-0.0.1-SNAPSHOT.jar
 */
@Slf4j
@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private KafkaTemplate template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        this.template.send("myTopic", "foo1");
        this.template.send("myTopic", "foo2");
        this.template.send("myTopic", "foo3");
        log.info("send all msg");
        latch.await(60, TimeUnit.SECONDS);
        log.info("All received");
    }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info("consume:{}", cr.toString());
        latch.countDown();
    }

}