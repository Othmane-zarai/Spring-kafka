package com.kafka.tuto.controllers;

import com.kafka.tuto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public void sendMessageToKafkaTopic(@RequestBody User user){
        System.out.println(user.toString());
        this.producer.sendMessage(user);
    }
}
