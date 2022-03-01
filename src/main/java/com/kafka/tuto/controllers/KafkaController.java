package com.kafka.tuto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kafka.tuto.services.Producer;

@RestController
@RequestMapping("/kafka")
@CrossOrigin
public class KafkaController {
    private final Producer producer;
    @Autowired
    KafkaController(Producer producer){
        this.producer = producer;
    }
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
    }
}
