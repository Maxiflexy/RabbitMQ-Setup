package com.maxiflexy.consumer;

import com.maxiflexy.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void consume(String message){
        log.info("Received message -> {}", message);
    }

    @RabbitListener(queues = "${rabbit.queue.json.name}")
    public void consumeJson(User user){
        log.info("Received json message -> {}", user.toString());
    }
}
