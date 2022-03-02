package com.kafka.tuto.services;

import com.kafka.tuto.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "users", groupId = "group_id")
    public User consume(User user) throws IOException {
        return user;
    }
}
