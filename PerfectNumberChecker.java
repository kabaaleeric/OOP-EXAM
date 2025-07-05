
import java.util.Scanner;// importing scanner to read user input
public class PerfectNumberChecker {
    public static void main(String[] args) {
        // Creating a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Keep running until user chooses to exit
        while (true) {
            try {
                // Getting and validating user input
                int number = getUserInput(scanner);  
                // Checking if the number is perfect
                boolean isPerfect = checkPerfectNumber(number);
                // Displaying the result
                displayResult(number, isPerfect); 
                // Asking if user wants to continue
                if (!askToContinue(scanner)) {
                    break;  // Exit the loop if user doesn't want to continue
                }
            } catch (Exception e) {
                // Handle any unexpected errors
                System.out.println("An error occurred: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
        // Close the scanner:
        scanner.close();
        System.out.println("Thank you for using Perfect Number Checker!");
    }
    private static int getUserInput(Scanner scanner) {
        int number = 0;
        boolean validInput = false;
        
        // Keep asking until we get valid input
        while (!validInput) {
            try {
                System.out.print("Enter a positive integer to check: ");
                String input = scanner.nextLine().trim();  // Read the entire line
                // Try to convert the input to an integer
                number = Integer.parseInt(input);
                // Check if the number is positive
                if (number <= 0) {
                    System.out.println("Error: Please enter a positive number!");
                    continue;  // Ask again
                }
                // If we get here, the input is valid
                validInput = true;   
            } catch (NumberFormatException e) {
                // This exception occurs when the input cannot be converted to an integer
                System.out.println("Error: Please enter a valid number (no letters or special characters)!");
            } catch (Exception e) {
                // Catch any other unexpected errors
                System.out.println("Error: " + e.getMessage());
            }
        }
        return number;
    }
    private static boolean checkPerfectNumber(int number) {
        // Find all proper divisors
        int sumOfDivisors = calculateSumOfDivisors(number);
        
        // Check if sum equals the original number
        return sumOfDivisors == number;
    }
    private static int calculateSumOfDivisors(int number) {
        int sum = 0;
        // We only need to check up to half of the number
        // because no number larger than number/2 can be a proper divisor
        for (int i = 1; i <= number / 2; i++) {
            // If the number divides evenly by i, then i is a divisor
            if (number % i == 0) {
                sum += i;  // Adding this divisor to the sum
            }
        }
        return sum;
    }
    private static void displayResult(int number, boolean isPerfect) {
        
        System.out.println("\nResults");
        System.out.println("Number to check: " + number);
        
        // Calculate and display all proper divisors
        System.out.print("Proper divisors: ");
        String divisors = getDivisorsString(number);
        System.out.println(divisors);
        
        // Calculate and display the sum
        int sum = calculateSumOfDivisors(number);
        System.out.println("Sum of divisors: " + sum);
        
        // Display the final result
        System.out.println();
        if (isPerfect) {
            System.out.println("RESULT: " + number + " IS a perfect number!");
            System.out.println("Because " + divisors + " = " + sum + " = " + number);
        } else {
            System.out.println("RESULT: " + number + " is NOT a perfect number.");
            System.out.println("Because " + divisors + " = " + sum + " ≠ " + number);
        }
        System.out.println();//empty line for readability of the codes
    }
    
    private static String getDivisorsString(int number) {
        StringBuilder divisors = new StringBuilder();
        boolean first = true;
        
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                if (!first) {
                    divisors.append(" + ");
                }
                divisors.append(i);
                first = false;
            }
        }
        
        return divisors.toString();
    }
    private static boolean askToContinue(Scanner scanner) {
        while (true) {//prompt the user if they want to continue with the program or not
            System.out.print("Do you want to check another numbe: ");
            String answer = scanner.nextLine().trim().toLowerCase();
            
            if (answer.equals("y") || answer.equals("yes")) {
                System.out.println();  // Add a blank line
                return true;
            } else if (answer.equals("n") || answer.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
}
    

