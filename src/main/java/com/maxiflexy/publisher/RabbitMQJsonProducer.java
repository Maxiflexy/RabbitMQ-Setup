package com.maxiflexy.publisher;

import com.maxiflexy.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbit.routing.json.key}")
    private String routingJsonKey;

    @Value("${rabbit.exchange.name}")
    private String exchange;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(User user){
        log.info("Json message sent -> {}", user.toString());
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
