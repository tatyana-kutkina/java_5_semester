package com.tatytanakutkina.task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryReader {
    public String toPath;
    public String sourcePath;
    public String namesList;

    public DirectoryReader(String toPath, String sourcePath) {

        File dir = new File(sourcePath);
        File file = new File(toPath);
        try {
            if (dir.exists() && dir.isDirectory() && file.exists() && file.isFile()) {
                String dirPath = dir.getCanonicalPath();
                String filePath = file.getCanonicalPath();
                this.sourcePath = dirPath;
                this.toPath = filePath;
            } else {
                throw new RuntimeException("There are some problems with paths");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void getList(String dirPath) {
        File dir = new File(dirPath);
        String[] fileNames = dir.list();

        if (fileNames != null) {
            for (String name : fileNames) {
                String path = dirPath + File.separator + name;
                File deepDir = new File(path);
                if (deepDir.isFile()) {
                    if (namesList == null) {
                        namesList = name + '\n';
                    } else {
                        namesList = namesList + name + '\n';
                    }

                }
                if (deepDir.isDirectory()) {
                    if (namesList == null) {
                        namesList = name + '\n';
                    } else {
                        namesList = namesList + name + '\n';
                    }
                    getList(path);
                }
            }

        } else {
            throw new RuntimeException("Directory is empty");
        }

    }

    public String list() {
        try (FileWriter writer = new FileWriter(toPath)) {
            this.getList(this.sourcePath);
            writer.write(this.namesList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return this.namesList;
    }

}
