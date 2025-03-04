import java.util.Arrays;
import java.util.List;

/**
 * Utility class for input validation in the Expense Tracker application.
 */
public class InputValidation {

    private static final List<String> VALID_CATEGORIES = Arrays.asList("food", "travel", "bills", "entertainment", "other");

    /**
     * Validates the amount.
     * @param amount the amount input as double.
     * @return true if amount is valid, else false
     */
    public static boolean validateAmount(double amount) {
        try {
            if (amount > 0 && amount < 1000) {
                return true;
            } else {
                System.out.println("Error: Amount must be greater than 0 and less than 1000.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid amount. Please enter a valid number.");
            return false;
        }
    }

    /**
     * Validates the category.
     * @param category the category input as a String.
     * @return true if the category is valid, false otherwise.
     */
    public static boolean validateCategory(String category) {
        if (VALID_CATEGORIES.contains(category.toLowerCase())) {
            return true;
        } else {
            System.out.println("Error: Invalid category. Must be one of: " + VALID_CATEGORIES);
            return false;
        }
    }
}
