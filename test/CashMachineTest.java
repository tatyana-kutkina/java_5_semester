import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class CashMachineTest {

    @Test
    public void testPositive_1() {
        Long[] noms = {2L, 1L};
        Long sum = 5L;
        int n = 2;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_1");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }

    @Test
    public void testPositive_2() {
        Long[] noms = {3000000000L};
        Long sum = 3000000000L;
        int n = 1;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_2");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }

    @Test
    public void testPositive_3() {
        Long[] noms = {1L, 1L, 1L};
        Long sum = 4L;
        int n = 3;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_3");
        CashMachine machine = new CashMachine(sum, n, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }

    @Test
    public void testPositive_4() {
        Long[] noms = {1L, 2L};
        Long sum = 4L;
        int n = 2;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_4");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }


    @Test
    public void testExceptionWrongInput_1() {
        Long[] noms = {5L};
        CashMachine machine = new CashMachine(6L, 1, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }

    // input is a negative value
    @Test
    public void testExceptionWrongInput_2() {
        Long[] noms = {5L};
        CashMachine machine = new CashMachine(-2L, 1, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }

    // input is a string
    @Test
    public void testExceptionWrongInput_3() {
        InputStream is = new ByteArrayInputStream("sss 2 1 2".getBytes());
        Assertions.assertThrows(InputMismatchException.class, () -> new CashMachine(is));

    }


}