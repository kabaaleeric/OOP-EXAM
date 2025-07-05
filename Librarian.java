
    import java.util.Scanner;  // Import the Scanner clas for reading user input
    public class Librarian {
    public static void main(String[] args) {
        
        // Create Scanner object for user input 
        Scanner scanner = new Scanner(System.in);
        
        // Display welcome message
        System.out.println("=== Uganda Word Counter for Librarians ===");
        System.out.println("This program counts occurrences of 'Uganda' in book descriptions.\n");
        
        // Prompt librarian to enter book description
        System.out.print("Please enter the book description: ");
        String bookDescription = scanner.nextLine();
        
        // Check if description is empty
        if (bookDescription.trim().isEmpty()) {
            System.out.println(" Error: Book description cannot be empty!");
            scanner.close();
            return;
        }
        
        // Count occurrences of "Uganda" (case-insensitive)
        int count = countUgandaOccurrences(bookDescription);
        
        // Display results
        displayResults(bookDescription, count);
        
        // Close scanner
        scanner.close();
    }
    private static int countUgandaOccurrences(String text) {
        
        // Convert text to lowercase for case-insensitive search
        String lowerText = text.toLowerCase();
        String searchWord = "uganda";
        
        int count = 0;
        int index = 0;
        
        // Find all occurrences of "uganda" in the lowercase text
        while ((index = lowerText.indexOf(searchWord, index)) != -1) {
            count++;
            index += searchWord.length(); // Move to next position after the found word
        }
        
        return count;
    }
    private static void displayResults(String description, int count) {
        
        System.out.println("\n=== Analysis Results ===");
        System.out.println("Book Description:");
        System.out.println("'" + description + "'");
        System.out.println();
        
        if (count == 0) {
            System.out.println(" The word 'Uganda' was not found in the description.");
        } else if (count == 1) {
            System.out.println(" Found 1 occurrence of 'Uganda' in the description.");
        } else {
            System.out.println(" Found " + count + " occurrences of 'Uganda' in the description.");
        }
        
        System.out.println("\nNote: Search was case-insensitive (uganda, Uganda, UGANDA, etc.)");
    }
}
    
