package com.app.kafkaproducer.controller;

import com.app.kafkaproducer.model.MessageDto;
import com.app.kafkaproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class TestController {

    @Autowired
    ProducerService service;

    @GetMapping("/test-producer")
    public void test() {
        System.out.println("Kafka log send starting...");
        for (int i = 0; i < 10; i++) {
            MessageDto s = new MessageDto();
            s.setMessage("Hello World");
            s.setVersion(String.format("[%d] -- Hello World", i));
            service.sendMessage(s);
        }
        System.out.println("Kafka log sent...");
    }
}
