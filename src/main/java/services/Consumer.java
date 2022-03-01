package services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "users", groupId = "group_id")
    public String consume(String message) throws IOException {
        return message;
    }
}
