public class Recipe {
    private int mealId;
    private String productName;
    private double amount;

    public Recipe(int mealId, String productName, double amount){
        this.mealId = mealId;
        this.productName = productName;
        this.amount = amount;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
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

    @Override
    public String toString() {
        return "Recipe{" +
                "mealId=" + mealId +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
