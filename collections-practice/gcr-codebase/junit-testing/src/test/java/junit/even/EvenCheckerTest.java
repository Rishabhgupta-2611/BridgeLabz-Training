package junit.even;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

	@ParameterizedTest
    @ValueSource(ints = {2, 4, 100, 2000})
    void testEvenNumbers(int number) {
        assertTrue(EvenChecker.isEven(number), number + " should be even");
    }

	@ParameterizedTest
    @ValueSource(ints = {1, 3, 101, 999})
    void testOddNumbers(int number) {
        assertFalse(EvenChecker.isEven(number), number + " should be odd");
    }
}
