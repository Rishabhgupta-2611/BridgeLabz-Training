package junit.registration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    UserRegistration userReg = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        boolean result = userReg.registerUser("Aryan", "aryan@example.com", "password123");
        assertEquals(true, result);
    }

    @Test
    void testEmptyUsername() {
        boolean result = userReg.registerUser("", "aryan@example.com", "password123");
        assertEquals(false, result);
    }

    @Test
    void testInvalidEmail() {
        boolean result = userReg.registerUser("Aryan", "aryanexample.com", "password123");
        assertEquals(false, result);
    }

    @Test
    void testShortPassword() {
        boolean result = userReg.registerUser("Aryan", "aryan@example.com", "123");
        assertEquals(false, result);
    }
}
