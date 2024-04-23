package br.com.alura.core.service;

import java.util.List;

public interface IConvertApi {

    <T> T convertData(String json, Class<T> tClass);

    <T> List<T> convertDataToList(String json, Class<T> tClass);
}
