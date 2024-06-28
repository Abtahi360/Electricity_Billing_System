public abstract class ElectricityBill {
    private String customerName;
    private double unitsConsumed;
    private double totalBillAmount;

    // Public constructor
    public ElectricityBill(String customerName, double unitsConsumed) {
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
        calculateBill();
    }

    // Abstract method for polymorphism
    public abstract void calculateBill();

    // Getter and setter methods for encapsulation
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
        calculateBill();
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    // Protected method for encapsulation
    protected void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public void displayBillDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill Amount: $" + totalBillAmount);
    }
}
