package com.tatyanakutkina.task3;

import com.tatytanakutkina.task3.MyHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashTableTest {

    @Test
    void testContainsCorrect() {
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        table.add(1, 10);
        table.add(2, 20);
        Assertions.assertTrue(table.contains(1));
    }

    @Test
    void testRemoveCorrectKey() {
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        table.add(1, 10);
        table.add(2, 20);
        table.remove(2);
        Assertions.assertFalse(table.contains(2));
        Assertions.assertEquals(1, table.size());
    }

    @Test
    void testRemoveNonExistentKey() {
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        table.add(1, 10);
        table.add(2, 20);
        Assertions.assertNull(table.remove(3));
    }


    @Test
    void testRemoveNegativeKey() {
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        table.add(1, 10);
        table.add(2, 20);
        Assertions.assertNull(table.remove(-10));
    }

    @Test
    void testAddCorrect() {
        MyHashTable<String, Integer> table = new MyHashTable<>();
        table.add("1", 10);
        table.add("2", 20);
        Assertions.assertTrue(table.contains("2"));
        Assertions.assertEquals(2, table.size());
    }

    @Test
    void testAddLoadFactorExceed() {
        MyHashTable<String, Integer> table = new MyHashTable<>(2);
        table.add("1", 10);
        table.add("2", 20);
        table.add("3", 30);
        Assertions.assertTrue(table.contains("3"));
        Assertions.assertEquals(3, table.size());
    }

    //need help with writing a test
    /*
    @Test
    void testRehashFunctionIsCalled() {
        com.tatytanakutkina.task3.MyHashTable<Integer, Integer> mock = Mockito.mock(com.tatytanakutkina.task3.MyHashTable.class);
        mock.add(2, 10);
        mock.add(3,10);
    }
     */

}