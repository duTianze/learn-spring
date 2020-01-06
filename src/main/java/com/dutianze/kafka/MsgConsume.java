package com.dutianze.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: dutianze
 * Date: 2020-01-03
 */
@Slf4j
@Component
public class MsgConsume {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());


        if (kafkaMessage.isPresent()) {
            log.info("接收消息: {}", kafkaMessage.get());

            Object message = kafkaMessage.get();
            System.out.println("---->" + record);
            System.out.println("---->" + message);
        }

    }
}
