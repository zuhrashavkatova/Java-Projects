import java.util.LinkedList;
import java.util.List;

public class CoffeeMachine {
    List<Product_> productList = new LinkedList<>();
    List<Coffee_> coffeeList = new LinkedList<>();

    public void addCoffee(String name, double price, double coffeeAmount, double milkAmount, double waterAmount) {
        coffeeList.add(new Coffee_(name, price, coffeeAmount, milkAmount, waterAmount));
    }

    public double getPrice(String coffeeName) {
        Coffee_ coffee = getCoffee(coffeeName);
        if (coffee != null){
            return coffee.getPrice();
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {

    }

    public double getCredit(int cardId) {
        return 0.0;
    }

    public int sell(String coffeeName, int cardId) {
        return 0;
    }

    public void refillProduct(String productName, int amount) {
        for (Product_ p :
                productList) {
            if (p.getName().equals(productName)) {
                p.setAmount(p.getAmount() + amount);
                return;
            }
        }
        productList.add(new Product_(productName, amount));
    }

    public boolean availableCoffee(String coffeeName) {
        Coffee_ coffee = getCoffee(coffeeName);
        boolean isAvailable = true;
        if (coffee != null){
            if (coffee.getCoffeeAmount() > getProduct("Coffee").getAmount()){
                isAvailable = false;
            }
            if (coffee.getMilkAmount() > getProduct("Milk").getAmount()){
                isAvailable = false;
            }
            if (coffee.getWaterAmount() > getProduct("Water").getAmount()){
                isAvailable = false;
            }
        }
        return isAvailable;
    }

    private Product_ getProduct(String name) {
        for(Product_ p:
           productList){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    private Coffee_ getCoffee(String coffeeName) {
        for (Coffee_ c :
                coffeeList) {
            if (c.getName().equals(coffeeName)){
                return c;
            }
        }
        return null;
    }
    public double availableProduct(String productName) {
        Product_ product = getProduct(productName);
        if (product != null){
            product.getAmount();
        }
        return -1;
    }
}

