package com.kafka.tuto.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.tuto.models.User;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;


import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class UserSerializer implements Serializer {
    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    public byte[] serialize(String topic, Headers headers, User user) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(user).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {
        Serializer.super.close();
    }

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }
}
