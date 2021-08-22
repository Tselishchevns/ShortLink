package com.company;


import com.company.strategy.StorageStrategy;

//уникальный ид для строки, если строки одинаковые, ид одинаковый
public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string){
        if (storageStrategy.containsValue(string)){
            return storageStrategy.getKey(string);
        }else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }
    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }
}
