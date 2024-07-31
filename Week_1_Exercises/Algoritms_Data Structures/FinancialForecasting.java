import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: If no years left to predict, return the present value
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: Calculate future value
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input present value, growth rate, and number of years
        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();
        System.out.print("Enter the growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        
        // Calculate future value
        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        
        // Output the result
        System.out.printf("The future value after %d years is: %.2f\n", years, futureValue);
    }
}
