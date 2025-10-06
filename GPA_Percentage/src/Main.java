import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

class GpaToPercentRange {

    // Returns the percent range string for a given (rounded) GPA key
    static String rangeForGpa(double gpa) {
        // Round to one decimal place using HALF_UP (3.95 -> 4.0, 3.94 -> 3.9)
        BigDecimal rounded = new BigDecimal(Double.toString(gpa)).setScale(1, RoundingMode.HALF_UP);

        // Validate range first
        if (rounded.doubleValue() < 0.0 || rounded.doubleValue() > 4.0) {
            return "Invalid GPA (must be between 0.0 and 4.0 inclusive).";
        }

        // Convert to an int key (e.g., 4.0 -> 40, 3.9 -> 39, ..., 0.0 -> 0)
        int key = rounded.multiply(BigDecimal.TEN).intValueExact();

        // Switch on the integer key
        switch (key) {
            case 40: return "100% to 95.0%";
            case 39: return "< 95.0% to 94.0%";
            case 38: return "< 94.0% to 93.0%";
            case 37: return "< 93.0% to 92.0%";
            case 36: return "< 92.0% to 91.0%";
            case 35: return "< 91.0% to 90.0%";
            case 34: return "< 90.0% to 89.0%";
            case 33: return "< 89.0% to 88.0%";
            case 32: return "< 88.0% to 87.0%";
            case 31: return "< 87.0% to 86.0%";
            case 30: return "< 86.0% to 85.0%";
            case 29: return "< 85.0% to 84.0%";
            case 28: return "< 84.0% to 83.0%";
            case 27: return "< 83.0% to 82.0%";
            case 26: return "< 82.0% to 81.0%";
            case 25: return "< 81.0% to 80.0%";
            case 24: return "< 80.0% to 79.0%";
            case 23: return "< 79.0% to 78.0%";
            case 22: return "< 78.0% to 77.0%";
            case 21: return "< 77.0% to 76.0%";
            case 20: return "< 76.0% to 75.0%";
            case 19: return "< 75.0% to 74.0%";
            case 18: return "< 74.0% to 73.0%";
            case 17: return "< 73.0% to 72.0%";
            case 16: return "< 72.0% to 71.0%";
            case 15: return "< 71.0% to 70.0%";
            case 14: return "< 70.0% to 69.0%";
            case 13: return "< 69.0% to 68.0%";
            case 12: return "< 68.0% to 67.0%";
            case 11: return "< 67.0% to 66.0%";
            case 10: return "< 66.0% to 65.0%";
            case 0:  return "< 65.0% to 0.0%";
            default:
                // Any tenths not covered above (e.g., 0.9 … 0.1) were not specified in the rubric.
                // You can decide to treat them as invalid or map them to "< 65.0% to 0.0%".
                return "GPA not in specified rubric (expected steps of 0.1 from 1.0 to 4.0, plus 0.0).";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter GPA (0.0 to 4.0): ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric GPA.");
            return;
        }
        double gpa = sc.nextDouble();
        String range = rangeForGpa(gpa);
        System.out.println("Percent range: " + range);
    }
}
