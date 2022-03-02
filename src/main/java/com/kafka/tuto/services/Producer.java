package com.kafka.tuto.services;

import com.kafka.tuto.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC= "users";
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public void sendMessage(User user){
        this.kafkaTemplate.send(TOPIC,user);
    }
}
