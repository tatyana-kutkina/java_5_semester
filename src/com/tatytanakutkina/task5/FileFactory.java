package com.tatytanakutkina.task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FileFactory implements ObjectFactory<FileWriter> {

    AtomicInteger id = new AtomicInteger(0);

    @Override
    public FileWriter createNew() {

        String path = System.getProperty("user.home") + File.separator + "Documents";
        path += File.separator + "Log Folder";
        File customDir = new File(path);

        if (!customDir.exists()) {
            customDir.mkdirs();
        }

        String now = String.valueOf(id.incrementAndGet());
        String fileName = "file" + now + ".txt";

        File file = new File(customDir + File.separator + fileName);
        try {
            return new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*
    public static void main(String[] args) {
        long timeMillis = 1000000;
        int size = 4;
        FileFactory factory = new FileFactory();
        ResourcePool<FileWriter> filePool = new ResourcePool<>(size, new FileFactory(), timeMillis);


    }*/

}
