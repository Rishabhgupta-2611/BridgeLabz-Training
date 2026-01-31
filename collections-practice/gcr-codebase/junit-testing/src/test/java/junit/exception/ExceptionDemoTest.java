package junit.exception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionDemoTest {

    ExceptionPractice demo = new ExceptionPractice();

    @Test
    void testDivideByZeroException() {
        assertThrows(ArithmeticException.class, () -> {
            demo.divide(10, 0);
        });
    }

    @Test
    void testDivideSuccess() {
        assertEquals(5, demo.divide(10, 2));
    }
}
