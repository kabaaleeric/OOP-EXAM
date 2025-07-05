
public class EmptyStringCreation {
    
    public static void main(String[] args) {
        
        System.out.println("Empty String Creation Methods\n");
        System.out.println("Demonstrating two ways to create empty strings");
        System.out.println("in the context of book record initialization.\n");
        
        // Demonstrate Method 1: String Literal
        demonstrateStringLiteral();
        
        // Demonstrate Method 2: String Constructor
        demonstrateStringConstructor();
        
        // Show practical book record initialization
        demonstrateBookRecordInitialization();
        
        System.out.println("End of Demonstration");
    }
   //First Method: String Literal
    // It uses the String Pool for memory efficiency.
   
    private static void demonstrateStringLiteral() {
        
        System.out.println("STRING LITERAL");
        System.out.println("----------------");
        System.out.println("Syntax: String variableName = \"\";\n");
        
        // Create empty strings using string literal
        String bookTitle = "";
        String authorName = "";
        String isbnNumber = "";
        String publisher = "";
        String publicationYear = "";
 
        // Display the empty strings
        System.out.println("Book Title: '" + bookTitle + "'");
        System.out.println("Author Name: '" + authorName + "'");
        System.out.println("ISBN Number: '" + isbnNumber + "'");
        System.out.println("Publisher: '" + publisher + "'");
        System.out.println("Publication Year: '" + publicationYear + "'");
        
        // Check properties
        System.out.println("\nProperties:");
        System.out.println("Length of bookTitle: " + bookTitle.length());
        System.out.println("Is bookTitle empty: " + bookTitle.isEmpty());
        System.out.println("Memory address (hashCode): " + System.identityHashCode(bookTitle));
        
        // Demonstrate that multiple empty string literals share the same object
        String anotherEmpty = "";
        System.out.println("Memory address of anotherEmpty: " + System.identityHashCode(anotherEmpty));
        System.out.println("Are they the same object? " + (bookTitle == anotherEmpty));
    }
    //Second Method: String Constructor
    private static void demonstrateStringConstructor() {
        
        System.out.println("\n\nSTRING CONSTRUCTOR");
        System.out.println("-------------------------");
        System.out.println("Syntax: String variableName = new String();\n");
        
        // Create empty strings using string constructor
        String bookTitle = new String();
        String authorName = new String();
        String isbnNumber = new String();
        String publisher = new String();
        String publicationYear = new String();
        
        // Display the empty strings
        System.out.println("Book Title: '" + bookTitle + "'");
        System.out.println("Author Name: '" + authorName + "'");
        System.out.println("ISBN Number: '" + isbnNumber + "'");
        System.out.println("Publisher: '" + publisher + "'");
        System.out.println("Publication Year: '" + publicationYear + "'");
        
        // Checkthe properties
        System.out.println("\nProperties:");
        System.out.println("Length of bookTitle: " + bookTitle.length());
        System.out.println("Is bookTitle empty: " + bookTitle.isEmpty());
        System.out.println("Memory address (hashCode): " + System.identityHashCode(bookTitle));
        
        // Demonstrate that constructor creates new objects
        String anotherEmpty = new String();
        System.out.println("Memory address of anotherEmpty: " + System.identityHashCode(anotherEmpty));
        System.out.println("Are they the same object? " + (bookTitle == anotherEmpty));
        System.out.println("Are they equal in content? " + bookTitle.equals(anotherEmpty));  
    }
     //Practical demonstration of book record initialization
     // Shows how empty strings are used in real-world scenarios
    private static void demonstrateBookRecordInitialization() {
        
        System.out.println("\n\n PRactical BOOK RECORD INITIALIZATION");
        System.out.println("-----------------------------");
        System.out.println("Showing how empty strings are used when creating new book records.\n");
        
        // Simulate a new book record being created in the NLU system
        System.out.println("Creating a new book record in NLU catalog system...\n");
        
        // Initialize book record fields with empty strings
        // This represents a book that has been received but not yet cataloged
        String bookTitle = "";           
        String authorName = "";          
        String isbnNumber = "";          
        String publisher = "";           
        String publicationYear = "";     
        String callNumber = "";          
        String subject = "";             
        
        // Display the initial state
        System.out.println("Initial Book Record State:");
        System.out.println("--------------------------");
        System.out.println("Title: '" + bookTitle + "'");
        System.out.println("Author: '" + authorName + "'");
        System.out.println("ISBN: '" + isbnNumber + "'");
        System.out.println("Publisher: '" + publisher + "'");
        System.out.println("Year: '" + publicationYear + "'");
        System.out.println("Call Number: '" + callNumber + "'");
        System.out.println("Subject: '" + subject + "'");
        
        // Check if record is complete
        boolean isComplete = !bookTitle.isEmpty() && 
                           !authorName.isEmpty() && 
                           !isbnNumber.isEmpty() && 
                           !publisher.isEmpty() && 
                           !publicationYear.isEmpty() && 
                           !callNumber.isEmpty() && 
                           !subject.isEmpty();
        
        System.out.println("\nRecord Status:");
        System.out.println("Is record complete: " + isComplete);
        System.out.println("Number of filled fields: " + countFilledFields(bookTitle, authorName, isbnNumber, publisher, publicationYear, callNumber, subject));
        
        // Simulate filling in some fields
        System.out.println("\nSimulating cataloging process...\n");
        
        bookTitle = "Things Fall Apart";
        authorName = "Chinua Achebe";
        isbnNumber = "978-0-435-90526-7";
        
        System.out.println("After partial cataloging:");
        System.out.println("Title: '" + bookTitle + "'");
        System.out.println("Author: '" + authorName + "'");
        System.out.println("ISBN: '" + isbnNumber + "'");
        System.out.println("Publisher: '" + publisher + "' (still empty)");
        System.out.println("Year: '" + publicationYear + "' (still empty)");
        
        // Check completion status again
        isComplete = !bookTitle.isEmpty() && 
                    !authorName.isEmpty() && 
                    !isbnNumber.isEmpty() && 
                    !publisher.isEmpty() && 
                    !publicationYear.isEmpty() && 
                    !callNumber.isEmpty() && 
                    !subject.isEmpty();
        
        System.out.println("\nUpdated Record Status:");
        System.out.println("Is record complete: " + isComplete);
        System.out.println("Number of filled fields: " + countFilledFields(bookTitle, authorName, isbnNumber, publisher, publicationYear, callNumber, subject));
    }
     //elper method to count how many fields are filled
    
    private static int countFilledFields(String... fields) {
        int count = 0;
        for (String field : fields) {
            if (!field.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
    
