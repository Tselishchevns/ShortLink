package com.company.strategy;

public interface StorageStrategy {
    boolean containsKey(Long key); //проверка ключа в хранилище
    boolean containsValue(String value); //проверка строки в хранилище
    void put(Long key, String value); // добавить в хранилище ключ-значение
    Long getKey(String value); //вернет ключ для строки
    String getValue(Long key); //вернет строку по ключу
}
