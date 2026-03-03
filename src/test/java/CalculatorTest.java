import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    void testSquareRoot() {
        assertEquals(5.0, Math.sqrt(25));
    }

    @Test
    void testLog() {
        assertEquals(2.30258509299, Math.log(10), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(8.0, Math.pow(2,3));
    }
}
