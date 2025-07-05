
public class StringConceptsDemo {
    public static void main(String[] args) {
        System.out.println("National Library of Uganda (NLU) Digital Catalog System");
        
        // Part A: Demonstrate String Immutability
        demonstrateStringImmutability();
        
        // Part B: Different ways to create empty strings
        demonstrateEmptyStringCreation();
        
        // Part C: String methods for search functionality
        demonstrateSearchMethods();
        
        System.out.println("End of String Concepts Demonstration");
    }
    
    /**
     * PART A: String Immutability Demonstration
     * 
     * String immutability means once a String object is created, it cannot be changed.
     * This  is crucial for the NLU system because:
     * 1. Security: Book titles and author names cannot be accidentally modified
     * 2. Efficiency: Multiple references can safely point to the same string
     * 3. Thread Safety: No risk of data corruption in multi-user environment
     */
    private static void demonstrateStringImmutability() {
        
        System.out.println("PART A: STRING IMMUTABILITY CONCEPT");
        System.out.println("=====================================");
        
        // Example 1: Basic immutability demonstration
        System.out.println("\n1. Basic String Immutability:");
        String bookTitle = "The Great Gatsby";
        System.out.println("Original book title: " + bookTitle);
        System.out.println("Memory address (hashCode): " + System.identityHashCode(bookTitle));
        
        // Try to "modify" the string (this creates a new object)
        String modifiedTitle = bookTitle.toUpperCase();
        System.out.println("After toUpperCase(): " + modifiedTitle);
        System.out.println("Original title unchanged: " + bookTitle);
        System.out.println("New object memory address: " + System.identityHashCode(modifiedTitle));
        
        // Example 2: Multiple references to the same string (String Pool)
        System.out.println("\n2. String Pool Efficiency:");
        String author1 = "Chinua Achebe";
        String author2 = "Chinua Achebe";  // Same string literal
        String author3 = new String("Chinua Achebe");  // New object
        
        System.out.println("author1 == author2: " + (author1 == author2));  // true (same object)
        System.out.println("author1 == author3: " + (author1 == author3));  // false (different objects)
        System.out.println("author1.equals(author3): " + author1.equals(author3));  // true (same content)
        
        // Example 3: Security benefits in library system
        System.out.println("\n3. Security Benefits in NLU System:");
        String patronQuery = "Things Fall Apart";
        String sanitizedQuery = patronQuery.trim();  // Creates new object, original unchanged
        
        System.out.println("Patron query: '" + patronQuery + "'");
        System.out.println("Sanitized query: '" + sanitizedQuery + "'");
        System.out.println("Original query preserved: '" + patronQuery + "'");
        
        // Example 4: Thread safety demonstration
        System.out.println("\n4. Thread Safety (Conceptual):");
        System.out.println("Multiple library staff can safely access the same book title");
        System.out.println("without risk of one person's changes affecting others.");
        System.out.println("Each operation creates a new string object if needed.");
    }
    
    /**
     * PART B: Different Ways to Create Empty Strings
     * 
     * In the NLU system, we might need empty strings for:
     * - Initializing book record fields
     * - Default values for optional metadata
     * - Clearing search results
     */
    private static void demonstrateEmptyStringCreation() {
        
        System.out.println("\n\nPART B: CREATING EMPTY STRINGS");
        System.out.println("===============================");
        
        // Method 1: String literal (most common and efficient)
        System.out.println("\n1. String Literal Method:");
        String emptyTitle = "";
        System.out.println("String literal: '" + emptyTitle + "'");
        System.out.println("Length: " + emptyTitle.length());
        System.out.println("Is empty: " + emptyTitle.isEmpty());
        
        // Method 2: String constructor
        System.out.println("\n2. String Constructor Method:");
        String emptyAuthor = new String();
        System.out.println("String constructor: '" + emptyAuthor + "'");
        System.out.println("Length: " + emptyAuthor.length());
        System.out.println("Is empty: " + emptyAuthor.isEmpty());
        
        // Method 3: String constructor with empty string parameter
        System.out.println("\n3. String Constructor with Empty Parameter:");
        String emptyISBN = new String("");
        System.out.println("String constructor with \"\": '" + emptyISBN + "'");
        System.out.println("Length: " + emptyISBN.length());
        
        // Method 4: Using String.valueOf() with null
        System.out.println("\n4. String.valueOf() Method:");
        String emptyPublisher = String.valueOf("");
        System.out.println("String.valueOf(): '" + emptyPublisher + "'");
        System.out.println("Length: " + emptyPublisher.length());
        
        // Practical example in library context
        System.out.println("\n5. Practical Library Application:");
        System.out.println("Initializing a new book record with empty fields:");
        
        // Simulate book record initialization
        String bookTitle = "";           // Will be filled when book is cataloged
        String authorName = "";          // Will be filled when author is identified
        String isbnNumber = "";          // Will be filled when ISBN is assigned
        String publisher = "";           // Will be filled when publisher is known
        
        System.out.println("Book Title: '" + bookTitle + "'");
        System.out.println("Author Name: '" + authorName + "'");
        System.out.println("ISBN Number: '" + isbnNumber + "'");
        System.out.println("Publisher: '" + publisher + "'");
        
        // Check if any field has been filled
        boolean hasTitle = !bookTitle.isEmpty();
        boolean hasAuthor = !authorName.isEmpty();
        System.out.println("Has title: " + hasTitle);
        System.out.println("Has author: " + hasAuthor);
    }
    
    /**
     * PART C: String Methods for Search Functionality
     * 
     * The NLU system needs robust search functionality that can handle:
     * - Case-insensitive searches
     * - Partial matches
     * - User input variations
     * - Accented characters
     */
    private static void demonstrateSearchMethods() {  
        System.out.println("\n\nPART C: SEARCH FUNCTIONALITY METHODS");
        
        // Sample book database (in real system, this would come from database)
        String[] bookTitles = {
            "Things Fall Apart",
            "The River Between",
            "A Man of the People",
            "Anthills of the Savannah",
            "No Longer at Ease"
        };
        
        String[] authors = {
            "Chinua Achebe",
            "Chinua Achebe",
            "Chinua Achebe",
            "Chinua Achebe",
            "Chinua Achebe"
        };
        
        System.out.println("\n1. equalsIgnoreCase() Method:");
        System.out.println("Allows case-insensitive exact matching");
        
        String userSearch = "things fall apart";
        System.out.println("User search: '" + userSearch + "'");
        
        for (int i = 0; i < bookTitles.length; i++) {
            boolean matches = bookTitles[i].equalsIgnoreCase(userSearch);
            if (matches) {
                System.out.println("✓ Found: '" + bookTitles[i] + "' by " + authors[i]);
            }
        }
        
        System.out.println("\n2. toLowerCase() Method:");
        System.out.println("Converts strings to lowercase for consistent comparison");
        
        String userAuthorSearch = "CHINUA ACHEBE";
        System.out.println("User author search: '" + userAuthorSearch + "'");
        String normalizedSearch = userAuthorSearch.toLowerCase();
        System.out.println("Normalized search: '" + normalizedSearch + "'");
        
        for (int i = 0; i < authors.length; i++) {
            String normalizedAuthor = authors[i].toLowerCase();
            if (normalizedAuthor.equals(normalizedSearch)) {
                System.out.println("✓ Found book by " + authors[i] + ": '" + bookTitles[i] + "'");
            }
        }
        System.out.println("\n3. Combined Search Functionality:");
        System.out.println("Demonstrating a complete search method");
        // Simulate a comprehensive search
        String searchTerm = "  THINGS FALL APART  ";  // User input with extra spaces
        System.out.println("Raw user input: '" + searchTerm + "'");
        
        // Clean and normalize the search term
        String cleanedSearch = searchTerm.trim().toLowerCase();
        System.out.println("Cleaned search: '" + cleanedSearch + "'");
        // Search in book titles
        System.out.println("\nSearching in book titles:");
        boolean found = false;
        for (String title : bookTitles) {
            if (title.toLowerCase().equals(cleanedSearch)) {
                System.out.println("✓ Exact match found: '" + title + "'");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No exact matches found.");
        }
        
        // Search with partial matching
        System.out.println("\n4. Partial Matching (contains method):");
        String partialSearch = "things";
        System.out.println("Partial search for: '" + partialSearch + "'");
        
        for (String title : bookTitles) {
            if (title.toLowerCase().contains(partialSearch.toLowerCase())) {
                System.out.println("✓ Partial match: '" + title + "'");
            }
        }    
    }
}
    
