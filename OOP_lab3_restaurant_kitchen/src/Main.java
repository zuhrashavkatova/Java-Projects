//import uz.muu.MealRecipes;
//import uz.muu.RestaurantKitchen;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestaurantKitchen restaurantKitchen = new RestaurantKitchen();

        restaurantKitchen.addMeal(1, "Plov", 20000);
        restaurantKitchen.addMeal(2, "Lagman", 15000);
        restaurantKitchen.addMeal(3, "Qozonkabob", 35000);

        restaurantKitchen.refillProduct("Meat", 30000, 60);
        restaurantKitchen.refillProduct("Oil", 10000, 15);
        restaurantKitchen.refillProduct("Potatoes", 50000, 18);
        restaurantKitchen.refillProduct("Onion", 20000,5);
        restaurantKitchen.refillProduct("Rice", 25000, 10);
        restaurantKitchen.refillProduct("Meat", 10000, 60);

        System.out.println(restaurantKitchen.getPrice(1));
        System.out.println(restaurantKitchen.getPrice(3));
//OVERALL=785000
        restaurantKitchen.addRecipe(1, "Meat", 1000);
        restaurantKitchen.addRecipe(1, "Oil", 400);
        restaurantKitchen.addRecipe(1, "Onion", 500);
        restaurantKitchen.addRecipe(1, "Rice", 1000);
//OVERALL=82500
        restaurantKitchen.addRecipe(2, "Meat", 1200);
        restaurantKitchen.addRecipe(2, "Oil", 500);
        restaurantKitchen.addRecipe(2, "Onion", 600);

        boolean mealAvailable = restaurantKitchen.availableMeal(1);

        restaurantKitchen.addWaiter(1, "Jon Snow");
        restaurantKitchen.addWaiter(2, "Tyrion Lannister");
        restaurantKitchen.addWaiter(3, "Daenerys Targaryen");
        restaurantKitchen.addWaiter(4, "Arya Stark");

        restaurantKitchen.sell(1, 4);
        restaurantKitchen.sell(2, 2);
        restaurantKitchen.sell(1, 3);
        restaurantKitchen.sell(3, 1);
        restaurantKitchen.sell(2, 4);
        restaurantKitchen.sell(1, 1);
        restaurantKitchen.sell(1, 4);

        System.out.println(restaurantKitchen.availableProduct("Oil"));
        System.out.println(restaurantKitchen.availableProduct("Rice"));

        List<MealRecipes> sortedSoldMealRecipes = restaurantKitchen.preparedMeal();
        for (MealRecipes mr :
                sortedSoldMealRecipes) {
            System.out.println(mr);
        }

//        restaurantKitchen.waitersSalary(1,"Daenerys Targaryen", 80000);
//        restaurantKitchen.waitersSalary(2,"Jon Snow", 100000);
//        restaurantKitchen.waitersSalary(3,"Tyrion Lannister", 200000);
//        restaurantKitchen.waitersSalary(4,"Arya Stark", 250000);

//        restaurantKitchen.waitersSalary(4);

        List<Waiter> waiterList = restaurantKitchen.getWaiterList();

        System.out.println("SALARIES:");
        for (Waiter w : waiterList) {
            double salary = restaurantKitchen.waitersSalary(w.getWaiterId());
            System.out.println(w.getWaiterFullname() + ": $" + salary);
        }

        double getPriceForRecipeOfMeal = restaurantKitchen.getPriceForRecipeOfMeal(1);
        System.out.println("Price For Recipe Of Meal: "+getPriceForRecipeOfMeal);

//     sotilgangan ovqatning narxidan ayirdi  sotgan waiterning salarysidan va countga ko'paytirdi
//        MEALID = 1 = 282 600 SUM
//        MEALID = 2= 148 500 SUM
        double totalMealSoldCost = restaurantKitchen.totalMealSoldCost(1);
        System.out.println("Total Cost for Meal: $"+totalMealSoldCost);

//        SUM = 431 100 SUM
        double totalRestaurantProfit = restaurantKitchen.totalRestaurantProfit();
        System.out.println("Total Restaurant Profit: $" + totalRestaurantProfit);
    }
}
