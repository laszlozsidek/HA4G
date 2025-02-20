package com.zsidek.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Slf4j
public class ResourceReader {

    public static JsonNode getJsonNode(String fileName) {
        ClassLoader classLoader = ResourceReader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + fileName);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static String getValueFromJsonNode(String fileName, String key) {
        return Objects.requireNonNull(getJsonNode(fileName)).get(key).asText();
    }

}
