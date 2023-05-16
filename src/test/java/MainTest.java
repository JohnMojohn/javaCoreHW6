import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MainTest {

    Main main;

    @BeforeEach
    public void beforeEach() {
        main = new Main();
    }

    @AfterEach
    public void afterEach() {
        main = null;
    }

    @Test
    public void TestTaxEarningsMinusSpendings() {
        int expected = 600, a = 7000, b = 3000;
        int result = main.taxEarningsMinusSpendings(a, b);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void TestTaxErningMinusPercent(){
        int expected = 540, a = 9000;
        int result = main.taxErningMinusPercent(a);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public  void TestTaxMinTax(){
        int a = 600, b = 540;
        Executable executable = ()-> main.taxMinTax(a, b);
        Assertions.assertDoesNotThrow(executable);

    }
}
