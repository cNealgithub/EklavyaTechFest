package com.CodersHubDspmu.EklavyaTechFest.Util;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

@Converter
public class JsonToMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        if (attribute == null) return null;
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("JSON writing error", e);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) return new HashMap<>();
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            throw new RuntimeException("JSON reading error", e);
        }
    }
}