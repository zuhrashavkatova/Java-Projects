public class Coffee_ {
    private String name;
    private double price, coffeeAmount, milkAmount, waterAmount;

    public Coffee_(String name, double price, double coffeeAmount, double milkAmount, double waterAmount) {
        this.name = name;
        this.price = price;
        this.coffeeAmount = coffeeAmount;
        this.milkAmount = milkAmount;
        this.waterAmount = waterAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCoffeeAmount() {
        return coffeeAmount;
    }

    public void setCoffeeAmount(double coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }

    public double getMilkAmount() {
        return milkAmount;
    }

    public void setMilkAmount(double milkAmount) {
        this.milkAmount = milkAmount;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.waterAmount = waterAmount;
    }

    @Override
    public String toString() {
        return "Coffee_{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", coffeeAmount=" + coffeeAmount +
                ", milkAmount=" + milkAmount +
                ", waterAmount=" + waterAmount +
                '}';
    }
}
