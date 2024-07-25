public class Product {
    private String productName;
    private double amount;
    private double priceFor1kg;
    public Product(String productName, double amount, double priceFor1kg) {
        this.productName = productName;
        this.amount = amount;
        this.priceFor1kg = priceFor1kg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPriceFor1kg() {
        return priceFor1kg;
    }

    public void setPriceFor1kg(double priceFor1kg) {
        this.priceFor1kg = priceFor1kg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                ", priceFor1kg=" + priceFor1kg +
                '}';
    }
}
