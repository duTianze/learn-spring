package com.dutianze.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author: dutianze
 * Date: 2020-01-03
 */
@Slf4j
@RestController
public class SendController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static Gson gson = new GsonBuilder().create();

    @GetMapping("send")
    public void send() {
        Message message = new Message();
        message.setId("KFK_" + System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());

        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send("test", gson.toJson(message));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("成功发送消息：{}，offset=[{}]", message, result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("消息：{} 发送失败，原因：{}", message, ex.getMessage());
            }
        });
    }
}
