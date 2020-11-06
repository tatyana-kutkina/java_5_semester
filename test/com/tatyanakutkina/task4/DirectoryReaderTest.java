package com.tatyanakutkina.task4;

import com.tatytanakutkina.task4.DirectoryReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectoryReaderTest {

    @Test
    void testFilesCorrect() {
        DirectoryReader reader = new DirectoryReader("writeFile", "./src/com/tatytanakutkina/task4/directory");
        String result = "fileTwo\n" +
                "fileOne\n" +
                "dirOne\n" +
                "dirThree\n" +
                "fileFive\n" +
                "fileFour\n" +
                "fileThree\n" +
                "dirTwo\n";
        Assertions.assertEquals(result, reader.list());
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

}
