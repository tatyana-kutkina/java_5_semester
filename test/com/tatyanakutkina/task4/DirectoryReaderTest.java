package com.tatyanakutkina.task4;

import com.tatytanakutkina.task4.DirectoryReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirectoryReaderTest {

    @Test
    void testFilesCorrect() {
        DirectoryReader reader = new DirectoryReader("writeFile", "/home/tatyana/Документы/Кр_басов/Перепись/16_3");
        String result = "20200524_123504.jpg\n" + "20200524_123447.jpg\n";
        Assertions.assertEquals(result, reader.list());

        try (BufferedReader br = new BufferedReader(new FileReader("writeFIle"))) {
            String line;
            String res = new String();
            while ((line = br.readLine()) != null) {
                res += line;
            }
        } catch (IOException e) {
            System.out.println("File read error.\n" + e.getMessage());
        }
    }

    @Test
    void testNonExistentDirectory() {
        String wrongPath = "./src/com/tatytanakutkina/task4/nonExistent";
        Assertions.assertThrows(RuntimeException.class, () -> new DirectoryReader("writeFile", wrongPath));
    }

    @Test
    void testDirectoryIsEmpty() {
        String wrongPath = "./src/com/tatytanakutkina/task4/emptyDirectory";
        DirectoryReader reader = new DirectoryReader("writeFile", wrongPath);
        Assertions.assertThrows(RuntimeException.class, reader::list);
    }

    @Test
    void testNonExistentWriteFile() {
        String dirPath = "./src/com/tatytanakutkina/task4/directory";
        Assertions.assertThrows(RuntimeException.class, () -> new DirectoryReader("nonExistentFile", dirPath));
    }

}
