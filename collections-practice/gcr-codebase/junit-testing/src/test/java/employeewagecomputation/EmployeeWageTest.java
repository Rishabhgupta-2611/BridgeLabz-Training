package employeewagecomputation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeWageTest {
    EmployeeWage employeeWage;

    @BeforeEach
    void setUp() {
        employeeWage = new EmployeeWage();
    }

    @Test
    void testFullTimeDailyWage() {
        int wage = employeeWage.getDailyWage(EmployeeWage.IS_FULL_TIME);
        assertEquals(160, wage);  // 8 * 20 = 160
    }

    @Test
    void testPartTimeDailyWage() {
        int wage = employeeWage.getDailyWage(EmployeeWage.IS_PART_TIME);
        assertEquals(80, wage);  // 4 * 20 = 80
    }

    @Test
    void testAbsentDailyWage() {
        int wage = employeeWage.getDailyWage(EmployeeWage.IS_ABSENT);
        assertEquals(0, wage);
    }

    @Test
    void testAttendance() {
        int attendance = employeeWage.getAttendance();
        assertTrue(attendance == 0 || attendance == 1);
    }

    @Test
    void testCalculateMonthlyWage() {
        employeeWage.calculateMonthlyWage();
        // Checking list is not empty
        assertFalse(employeeWage.dailyWageList.isEmpty());
        // Check wages are valid values
        for (int wage : employeeWage.dailyWageList) {
            assertTrue(wage == 0 || wage == 80 || wage == 160);
        }
    }
}