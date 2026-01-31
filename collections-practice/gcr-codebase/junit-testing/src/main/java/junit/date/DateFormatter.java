package junit.date;
import java.text.*;
import java.util.*;

public class DateFormatter {

    public String formatDate(String inputDate) {
        try {
            // Input format: yyyy-MM-dd
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            inputFormat.setLenient(false); // Strict parsing

            Date date = inputFormat.parse(inputDate);	// Parse the input date

            // Output format: dd-MM-yyyy
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            return outputFormat.format(date);

        } catch (ParseException e) {
            return "Invalid date";
        }
    }
}
