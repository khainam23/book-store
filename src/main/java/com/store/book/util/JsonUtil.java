package com.store.book.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.book.config.ICMessage;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonUtil {
    final ObjectMapper mapper = new ObjectMapper();

    public String convertObjToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("");
        }
    }

    public <T> T convertJsonToObj(String json, Class<T> classObj) {
        try {
            return mapper.readValue(json, classObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("");
        }
    }
}
