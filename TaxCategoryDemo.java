
// Base class for tax categories
class TaxCategory {
    protected String categoryName;
    protected double vatRate;
    
    public TaxCategory(String name, double rate) {
        this.categoryName = name;
        this.vatRate = rate;
    }
    
    public double calculateVAT(double amount) {
        return amount * (vatRate / 100.0);
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public double getVatRate() {
        return vatRate;
    }
}

// Retailer subclass - applies 18% VAT rate
// Inherits from TaxCategory and overrides calculateVAT method
class Retailer extends TaxCategory {
    
    
    public Retailer() {
        super("Retailer", 18.0);  // Call parent constructor with 18% rate
    }
    @Override
    public double calculateVAT(double amount) {
        return amount * (18.0 / 100.0);  // 18% VAT calculation
    }
}
class Wholesaler extends TaxCategory {
    
    public Wholesaler() {
        super("Wholesaler", 15.0);  // Call parent constructor with 15% rate
    }
    
    @Override
    public double calculateVAT(double amount) {
        return amount * (15.0 / 100.0);  // 15% VAT calculation
    }
}
class Importer extends TaxCategory {
      //Constructor for Importer
     //Sets VAT rate to 10%
    public Importer() {
        super("Importer", 10.0);  // Call parent constructor with 10% rate
    }
    
    @Override
    public double calculateVAT(double amount) {
        return amount * (10.0 / 100.0);  // 10% VAT calculation
    }
}

  //Main class to demonstrate the TaxCategory hierarchy
public class TaxCategoryDemo { 
    public static void main(String[] args) {
        
        System.out.println("Tax Category VAT Calculation\n");
        
        // Creating an array of TaxCategory objects
        // This demonstrates polymorphism - we can store different subclass objects
        // in an array of the base class type
        TaxCategory[] taxCategories = new TaxCategory[3];
        // Initialize the array with different subclass objects
        taxCategories[0] = new Retailer();    // Retailer object has  (18% VAT)
        taxCategories[1] = new Wholesaler();  // Wholesaler object  has (15% VAT)
        taxCategories[2] = new Importer();    // Importer object has (10% VAT)
        
        // Test amounts for VAT calculation
        double[] testAmounts = {1000.0, 2500.0, 5000.0, 10000.0};
        
        // Demonstrating runtime polymorphism (dynamic method dispatch)
        // The same method call will execute different implementations
        // based on the actual object type at runtime
        for (double amount : testAmounts) {
            System.out.println("Transaction Amount: $" + String.format("%.2f", amount));
            System.out.println("----------------------------------------");
            
            // Loop through each tax category and calculate VAT
            // This is where runtime polymorphism occurs!
            for (TaxCategory category : taxCategories) {
                // The calculateVAT method called here will be the one
                // from the actual object type (Retailer, Wholesaler, or Importer)
                double vatAmount = category.calculateVAT(amount);
                double totalAmount = amount + vatAmount;
                
                // Displaying the results
                System.out.printf("%-12s: VAT Rate: %.1f%% | VAT Amount: $%.2f | Total: $%.2f%n",
                    category.getCategoryName(),
                    category.getVatRate(),
                    vatAmount,
                    totalAmount);
            }
            System.out.println(); // Empty line for readability
        }
        
    }
}
