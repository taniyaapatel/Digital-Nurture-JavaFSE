package advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class AdvancedTest {

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8 })
    public void testIsEven(int number) {
        assertTrue(number % 2 == 0);
    }

    @Test
    public void testException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Invalid input");
        });
        assertEquals("Invalid input", exception.getMessage());
    }
}
