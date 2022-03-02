package com.kafka.tuto.deserializers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.tuto.models.User;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(data, User.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return null;
    }
}
