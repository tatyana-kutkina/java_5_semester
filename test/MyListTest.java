import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyListTest {

    @Test
    void testListIsEmpty() {
        MyList list = new MyList(5);
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void testAddToEndOfList() {
        MyList list = new MyList(10);
        list.add(1);
        list.add(2);
        list.add(3);
        Assertions.assertEquals(list.get(2), 3);
    }

    @Test
    void testAddWithIndex() {
        MyList list = new MyList(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, "sss");
        Assertions.assertEquals(list.get(1), "sss");
    }

    @Test
    void testAddWithNegativeIndex() {
        MyList list = new MyList(10);
        list.add(0, 1);
        Assertions.assertThrows(RuntimeException.class, () -> list.add(-5, 10));
    }

    @Test
    void testAddWithIndexLargerMaxSize() {
        MyList list = new MyList(10);
        list.add(0, 1);
        Assertions.assertThrows(RuntimeException.class, () -> list.add(20, 10));
    }

    @Test
    void testNoMoreSpaceToAddElement() {
        MyList list = new MyList(2);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> list.add(1, 10));
    }

    @Test
    void testContainsCorrect() {
        MyList list = new MyList(2);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertTrue(list.contains(1));
    }

    @Test
    void testGetElementCorrect() {
        MyList list = new MyList(2);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertEquals(2, list.get(1));
    }

    @Test
    void testGetElementNegativeIndex(){
        MyList list = new MyList(10);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> list.get(-5));
    }

    @Test
    void testGetWithTooLargeIndex(){
        MyList list = new MyList(10);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> list.get(5));
    }


    @Test
    void testRemoveCorrect() {
        MyList list = new MyList(2);
        list.add(0, 1);
        list.add(1, 2);
        list.remove(1);
        Assertions.assertFalse(list.contains(2));
    }


    @Test
    void testRemoveWithTooLargeIndex(){
        MyList list = new MyList(10);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> list.remove(5));
    }

    @Test
    void testRemoveWithNegativeIndex(){
        MyList list = new MyList(10);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertThrows(RuntimeException.class, () -> list.remove(-5));
    }

    @Test
    void testSize() {
        MyList list = new MyList(10);
        list.add(0, 1);
        list.add(1, 2);
        Assertions.assertEquals(list.size(), 2);
    }
}
