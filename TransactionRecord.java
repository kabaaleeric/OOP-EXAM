

public class TransactionRecord {
    //private fields to be accessed using the setters and getters
    private int buyerTIN;
    private int sellerTIN;
    private double transactionAmount;
    private String transactionDate;
    
    //creating a constructor for easy initialisation of the fields
    public TransactionRecord(int buyerTIN, int sellerTIN, double transactionAmount, String transactionDate) {
        this.buyerTIN = buyerTIN;
        this.sellerTIN = sellerTIN;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }
    
    //getters and setters to access the private fields
    public int getBuyerTIN() {
        return buyerTIN;
    }
    public void setBuyerTIN(int buyerTIN) {
        this.buyerTIN = buyerTIN;
    }
    public int getSellerTIN() {
        return sellerTIN;
    }
    public void setSellerTIN(int sellerTIN) {
        this.sellerTIN = sellerTIN;
    }
    public double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public String getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
