//import uz.muu.CoffeeMachine;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();

        cm.addCoffee("Cappuccino", 7000, 100, 100, 100);
        cm.addCoffee("Espresso", 6000, 100, 0, 100);
        cm.addCoffee("Macchiato", 7000, 100, 50, 150);

        cm.refillProduct("Coffee", 1000);
        cm.refillProduct("Coffee", 500);
        cm.refillProduct("Milk", 70);
        cm.refillProduct("Water", 500);

        boolean espressoAvailable = cm.availableCoffee("Espresso");
        boolean cappuccinoAvailable = cm.availableCoffee("Cappuccino");
        boolean macchiatoAvailable = cm.availableCoffee("Macchiato");

        System.out.println(cm.getPrice("Cappuccino"));

        cm.rechargeCard(7, 50000);
        cm.rechargeCard(11, 10000);
        cm.rechargeCard(24, 7500);

        cm.sell("Cappuccino", 11);
        cm.sell("Espresso", 7);
//        cm.sell("Macchiato", 24);
//        cm.sell("Macchiato", 24);

        System.out.println(cm.availableProduct("Milk"));

        System.out.println(cm.getCredit(11));
    }
}