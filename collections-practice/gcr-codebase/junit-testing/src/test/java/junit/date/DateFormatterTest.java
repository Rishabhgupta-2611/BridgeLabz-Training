package junit.date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    public void testValidDate() {
        DateFormatter df = new DateFormatter();
        String result = df.formatDate("2026-01-30");
        assertEquals("30-01-2026", result);
    }

    @Test
    public void testInvalidDate() {
        DateFormatter df = new DateFormatter();
        String result = df.formatDate("2026-13-30"); // Invalid month
        assertEquals("Invalid date", result);
    }

    @Test
    public void testWrongFormatDate() {
        DateFormatter df = new DateFormatter();
        String result = df.formatDate("30/01/2026"); // Wrong format
        assertEquals("Invalid date", result);
    }
}
