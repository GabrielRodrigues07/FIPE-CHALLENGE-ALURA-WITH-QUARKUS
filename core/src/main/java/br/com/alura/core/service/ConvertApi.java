package br.com.alura.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertApi implements IConvertApi{

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T convertData(String json, Class<T> tClass) {
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> convertDataToList(String json, Class<T> tClass) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, tClass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
