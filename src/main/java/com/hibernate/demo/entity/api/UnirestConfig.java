package com.hibernate.demo.entity.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Config;
import kong.unirest.Unirest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnirestConfig {

    private final com.fasterxml.jackson.databind.ObjectMapper mapper;

    public UnirestConfig(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    public Config unirest() {
        System.out.println("postConstruct");
        return Unirest.config().setObjectMapper(new kong.unirest.ObjectMapper() {

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
