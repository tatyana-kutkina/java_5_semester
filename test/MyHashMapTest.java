import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

    @Test
    void testMapIsNotEmpty() {
        MyHashMap map = new MyHashMap();
        map.put(1, 12);
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    void testMapContainsKey() {
        MyHashMap map = new MyHashMap();
        map.put(1, 12);
        Assertions.assertTrue(map.containsKey(1));
    }

    @Test
    void testMapNotContainsKey() {
        MyHashMap map = new MyHashMap();
        map.put(1, 12);
        Assertions.assertFalse(map.containsKey(3));
    }

    @Test
    void testMapPutNull() {
        MyHashMap map = new MyHashMap();
        map.put(1, 12);
        Assertions.assertNull(map.put(2, null));
    }

    @Test
    void testMapPutExictedKey() {
        MyHashMap map = new MyHashMap();
        map.put(1, 12);
        Assertions.assertEquals(map.put(1, 10), 12);
        Assertions.assertEquals(map.get(1), 10);
    }


    @Test
    void testMapGetCorrectKey() {
        MyHashMap map = new MyHashMap();
        map.put("sss", 5);
        map.put(1, "string");
        Assertions.assertEquals(map.get(1), "string");
    }

    @Test
    void testMapGetNonExistentKey() {
        MyHashMap map = new MyHashMap();
        map.put("sss", 5);
        map.put(1, "string");
        Assertions.assertNull(map.get(2));
    }
}