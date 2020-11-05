import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    @Test
    void testStackIsEmpty() {
        MyStack stack = new MyStack();
        Assertions.assertTrue(stack.empty());
    }

    @Test
    void testPeekCorrect() {
        MyStack stack = new MyStack();
        stack.push(5);
        Assertions.assertEquals(5, stack.peek());
    }

    @Test
    void testPopCorrect() {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(10);
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    void testPushCorrect() {
        MyStack stack = new MyStack();
        stack.push(5);
        Assertions.assertEquals(1, stack.size());
        Assertions.assertEquals(5, stack.peek());
    }

    @Test
    void testPopFromEmptyStack() {
        MyStack stack = new MyStack();
        Assertions.assertNull(stack.pop());
    }

}
