package com.company.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
        path = Files.createTempFile(Integer.toHexString(hashCode()),".tmp");
        path.toFile().deleteOnExit();

            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void putEntry(Entry entry) {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(path))){
            os.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public Entry getEntry() {
        if (getFileSize() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                return (Entry) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
