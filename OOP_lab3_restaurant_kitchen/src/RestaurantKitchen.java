//package uz.muu;

import com.sun.source.tree.BreakTree;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RestaurantKitchen {
    List<Meal> mealList = new LinkedList<>();
    List<Recipe> recipeList = new LinkedList<>();
    List<Product> productList = new LinkedList<>();
    List<Waiter> waiterList = new LinkedList<>();
    List<MealRecipes> mealRecipesList = new LinkedList<>();

    public void addMeal(int mealId, String mealName, double mealPrice) {
        mealList.add(new Meal(mealId, mealName, mealPrice));
    }

    public void addRecipe(int mealId, String productName, double amount) {
        recipeList.add(new Recipe(mealId, productName, amount));
    }

    public double getPrice(int mealId) {
        for (Meal m : mealList) {
            if (m.getMealId() == mealId) {
                System.out.println("Price of " + m.getMealName());
                return m.getMealPrice();
            }
        }
        return -1;
    }

    public void refillProduct(String productName, double amount, double priceFor1kg) {
        Product product = getProduct(productName);
        if (product == null) {
            productList.add(new Product(productName, amount, priceFor1kg));
        } else {
            product.setAmount(product.getAmount() + amount);
        }
    }

    private Product getProduct(String productName) {
        for (Product p : productList) {
            if (p.getProductName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    public double availableProduct(String productName) {
        for (Product p : productList) {
            if (p.getProductName().equals(productName)) {
                System.out.println("Amount of " + p.getProductName());
                return p.getAmount();
            }
        }
        return -1;
    }

    public boolean availableMeal(int mealId) {
        for (Meal m : mealList) {
            if (m.getMealId() == mealId) {
//                System.out.println(m.getMealName() + " is available");
                return true;
            }
        }
        return false;
    }

    public void addWaiter(int waiterId, String waiterFullname) {
        waiterList.add(new Waiter(waiterId, waiterFullname));
    }

    public boolean availableWaiter(int waiterId) {
        for (Waiter w : waiterList) {
            if (w.getWaiterId() == waiterId) {
//                System.out.println(w.getWaiterFullname()+" waiter have in our restaurant");
                return true;
            }
        }
        return false;
    }

//    by_me
//    public boolean sell(int mealId, int waiterId) {
//        if (availableMeal(mealId) && availableWaiter(waiterId)) {
//            List<Recipe> mealRecipeList = getMealProducts(mealId);
//            for (Recipe r : mealRecipeList) {
//                for (Product p : productList) {
//                    if (r.getProductName().equals(p.getProductName())) {
//                        if (r.getAmount() < p.getAmount()){
//                            p.setAmount(p.getAmount() - r.getAmount());
////                            return true;
//                        }
////                        return false;
//                    }
//                }
//            }
//
//        }
//        boolean found = false;
//        for (MealRecipes mealRecipes : mealRecipesList) {
//            if (mealRecipes.getMealId() == mealId) {
//                mealRecipes.setCount(mealRecipes.getCount() + 1);
//                mealRecipes.addWaiterId(waiterId);
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            mealRecipesList.add(new MealRecipes(mealId, 1, waiterId));
//        }
//        return true;
//    }

//    bychatgpt without salary
//public boolean sell(int mealId, int waiterId) {
//    if (availableMeal(mealId) && availableWaiter(waiterId)) {
//        List<Recipe> mealRecipeList = getMealProducts(mealId);
//        boolean productsAvailable = true;
//        double totalMealCost = 0.0;
//        for (Recipe r : mealRecipeList) {
//            boolean productFound = false;
//            for (Product p : productList) {
//                if (r.getProductName().equals(p.getProductName())) {
//                    if (r.getAmount() <= p.getAmount()) {
//                        productFound = true;
//                        break; // Found the required product, move to the next recipe
//                    } else {
//                        productsAvailable = false;
//                        break; // Product not available in sufficient quantity, exit loop
//                    }
//                }
//            }
//            if (!productFound) {
//                productsAvailable = false;
//                break; // Required product not found, exit loop
//            }
//        }
//        if (productsAvailable) {
//            for (Recipe r : mealRecipeList) {
//                for (Product p : productList) {
//                    if (r.getProductName().equals(p.getProductName())) {
//                        p.setAmount(p.getAmount() - r.getAmount());
//                    }
//                }
//            }
//            boolean found = false;
//            for (MealRecipes mealRecipes : mealRecipesList) {
//                if (mealRecipes.getMealId() == mealId) {
//                    mealRecipes.setCount(mealRecipes.getCount() + 1);
//                    mealRecipes.addWaiterId(waiterId);
//                    found = true;
//                    break;
//                }
//            }
//            for (Waiter w: waiterList){
//                for (Meal m:mealList) {
//                    if (w.getWaiterId() == waiterId) {
//                        w.setSalary(w.getSalary() + m.getMealPrice() / 10);
//                        break;
//                    }
//                }
//            }
//            if (!found) {
//                mealRecipesList.add(new MealRecipes(mealId, 1, waiterId));}
//            return true;
//        } else {
//            return false; // Products not available in sufficient quantity
//        }
//    }
//    return false; // Meal or waiter not available
//}


    //    by ch with salary
    public boolean sell(int mealId, int waiterId) {
        if (availableMeal(mealId) && availableWaiter(waiterId)) {
            Meal mealFound = null;
            for (Meal m : mealList) {
                if (m.getMealId() == mealId) {
                    mealFound = m;
                    break;
                }
            }
            if (mealFound != null) {
                double mealPrice = mealFound.getMealPrice();
                for (Recipe r : recipeList) {
                    if (r.getMealId() == mealId) {
                        for (Product p : productList) {
                            if (p.getProductName().equals(r.getProductName())) {
                                if (p.getAmount() < r.getAmount()) {
                                    return false;
                                }
                                p.setAmount(p.getAmount() - r.getAmount());
                            }
                        }
                    }
                }
                // Update waiter's salary
                for (Waiter waiter : waiterList) {
                    if (waiter.getWaiterId() == waiterId) {
                        waiter.setSalary(waiter.getSalary() + mealPrice * 0.1); // 10% commission
                        break;
                    }
                }

                // Update meal recipes
                boolean found = false;
                for (MealRecipes mealRecipes : mealRecipesList) {
                    if (mealRecipes.getMealId() == mealId) {
                        mealRecipes.setCount(mealRecipes.getCount() + 1);
                        mealRecipes.addWaiterId(waiterId);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    mealRecipesList.add(new MealRecipes(mealId, 1, waiterId));
                }
                return true;
            }
        }
        return false; // Meal or waiter not available
    }

    // private List<Recipe> getMealProducts(int mealId){
//        List<Recipe> newRecipeList = new LinkedList<>();
//        for (Recipe r: recipeList){
//            if (r.getMealId() == mealId){
//                newRecipeList.add(r);
//            }
//        }
//        return newRecipeList;
//    }
    public List<MealRecipes> preparedMeal() {
        Collections.sort(mealRecipesList);
        return mealRecipesList;
    }

    public List<Waiter> getWaiterList() {
        return waiterList;
    }

//    public double waitersSalary(int mealId, String waiterFullName, int salary) {
//        return 1;
//    }

    public double waitersSalary(int waiterId) {
        for (Waiter w : waiterList) {
            if (w.getWaiterId() == waiterId) {
                return w.getSalary();
            }
        }
        return -1;
    }

    //by_me
//    public double getPriceForRecipeOfMeal(int mealId){
//        double price = 0.0;
//        if (availableMeal(mealId)){
//            for (Product p:productList){
//                for (Recipe r: recipeList){
//                    if (p.getProductName().equals(r.getProductName())){
//                        price = r.getAmount() * p.getPriceFor1kg();
//                    }
//                }
//            }
//        }
//        return price;
//    }
    public double getPriceForRecipeOfMeal(int mealId) {
        double totalPrice = 0.0;
        if (availableMeal(mealId)) {
            for (Recipe r : recipeList) {
                if (r.getMealId() == mealId) {
                    String productName = r.getProductName();
                    double amount = r.getAmount();
                    Product p = getProduct(productName);
                    if (p != null) {
                        double extraPrice = (amount * p.getPriceFor1kg())/1000;
                        totalPrice += extraPrice;
                    }
                }
            }
        }
        return totalPrice;
    }

    public double totalMealSoldCost(int mealId) {
        double totalCost = 0.0;
        double p = 0.0;
        if (availableMeal(mealId)) {
            p = getPriceForRecipeOfMeal(mealId);
            int soldCount = 0;
            for (MealRecipes mealRecipes : mealRecipesList) {
                if (mealRecipes.getMealId() == mealId) {
                    int count = mealRecipes.getCount();
                    soldCount += count;
                    totalCost = (p-p/10)*soldCount;
                }
            }
        }
        return totalCost;
    }

    public double totalRestaurantProfit() {
        double totalProfit = 0.0;
        for (Meal m : mealList) {
            double mealSoldCost = totalMealSoldCost(m.getMealId());
            if (mealSoldCost > 0) {
                totalProfit += mealSoldCost;
            }
        }
        return totalProfit;
    }
}


//      INCORRECT_ANSWER
//    public double totalMealSoldCost(int mealId) {
//        double totalCost = 0.0;
//        Meal meal = getMealById(mealId);
//        if (meal != null) {
//            double mealPrice = meal.getMealPrice();
//            double waiterSalary = 0.0;
//            int soldCount = 0;
//            for (MealRecipes mealRecipes : mealRecipesList) {
//                if (mealRecipes.getMealId() == mealId) {
//                    int count = mealRecipes.getCount();
//                    soldCount += count;
//                    for (Waiter waiter : waiterList) {
//                        if (mealRecipes.getWaiterIdList().contains(waiter.getWaiterId())) {
//                            waiterSalary += mealPrice * 0.1; // Calculate waiter's salary for this meal
//                            break;
//                        }
//                    }
//                }
//            }
//            totalCost = (mealPrice - waiterSalary)*soldCount; // Deduct waiter's salary from meal price
//        }
//        return totalCost;
//    }
//
//    private Meal getMealById(int mealId) {
//        for (Meal meal : mealList) {
//            if (meal.getMealId() == mealId) {
//                return meal;
//            }
//        }
//        return null;
//    }
//

















//    public List<Waiter> waitersSalary() {
//        List<Waiter> sortedWaiters = new LinkedList<>(waiterList);
//        sortedWaiters.sort(Comparator.comparingDouble(Waiter::getSalary));
//        return sortedWaiters;
//    }

//    public double waitersSalary(int waiterId, String waiterFullname) {
//        for (Waiter waiter: waiterList){
//            return waiter.getSalary();
//        }
//        return -1.0;
//    }


