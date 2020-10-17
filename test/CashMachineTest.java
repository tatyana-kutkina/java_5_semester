import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CashMachineTest {

    @Test
    public void testPositive() {
        long[] noms = {2, 1};
        CashMachine expected = new CashMachine(5, 2, noms, "expected");
        CashMachine machine = new CashMachine(5, 2, noms);
        machine.getCombinations();
        Assertions.assertEquals(machine, expected);
    }

    @Test
    public void testExceptionWrongInput(){
        long[] noms = {2, 1};
        CashMachine machine = new CashMachine(-2, 2, noms);
        Assertions.assertThrows(RuntimeException.class, machine::getCombinations);
    }




}