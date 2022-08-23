package com.app.kafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "testTopic", groupId = "${spring.kafka.group-id}")
    public void listen(String message) {
        System.out.println(String.format("Received Messasge: [%s] ", message));
    }
}