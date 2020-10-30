import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class CashMachineTest {

    @Test
    public void testSumFiveNominals12() {
        Long[] noms = {2L, 1L};
        Long sum = 5L;
        int n = 2;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_1");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }

    @Test
    public void testBigSum() {
        Long[] noms = {3000000000L};
        Long sum = 3000000000L;
        int n = 1;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_2");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }

    @Test
    public void testDuplicatedNominals() {
        InputStream is = new ByteArrayInputStream("4 3 1 1 1".getBytes());
        Assertions.assertThrows(RuntimeException.class, () -> new CashMachine(is));
    }

    @Test
    public void testSumFourNominals12() {
        Long[] noms = {1L, 2L};
        Long sum = 4L;
        int n = 2;
        CashMachine expected = new CashMachine(sum, n, noms, "expected_4");
        CashMachine machine = new CashMachine(sum, n, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }


    @Test
    public void testExceptionSumLowerThanNominals() {
        Long[] noms = {6L};
        CashMachine machine = new CashMachine(5L, 1, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }

    @Test
    public void testExceptionNegativeInput() {
        InputStream is = new ByteArrayInputStream("-2 1 5".getBytes());
        Assertions.assertThrows(RuntimeException.class, () -> new CashMachine(is));
    }

    @Test
    public void testExceptionInputIsString() {
        InputStream is = new ByteArrayInputStream("sss 2 1 2".getBytes());
        Assertions.assertThrows(InputMismatchException.class, () -> new CashMachine(is));
    }


}