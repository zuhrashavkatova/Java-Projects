public class Meal {
    private int mealId;
    private String mealName;
    private double mealPrice;

    public Meal(int mealId, String mealName, double mealPrice) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealPrice=" + mealPrice +
                '}';
    }
}