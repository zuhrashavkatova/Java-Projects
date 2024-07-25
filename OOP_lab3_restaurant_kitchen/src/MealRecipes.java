//1method
// public class MealRecipes implements  Comparable<MealRecipes>{
//    private int mealId;
//    private int count;
//    private int waiterId;
//
//    public MealRecipes(int mealId, int count,int waiterId) {
//        this.mealId = mealId;
//        this.count = count;
//        this.waiterId = waiterId;
//
//    }
//
//    public int getMealId() {
//        return mealId;
//    }
//
//    public void setMealId(int mealId) {
//        this.mealId = mealId;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public int getWaiterId() {
//        return waiterId;
//    }
//
//    public void setWaiterId(int waiterId) {
//        this.waiterId = waiterId;
//    }
//
//    @Override
//    public String toString() {
//        return "MealRecipes{" +
//                "mealId=" + mealId +
//                ", count=" + count +
//                ", waiterId=" + waiterId +
//                '}';
//    }
//
//    @Override
//    public int compareTo(MealRecipes mr) {
//        return this.count - mr.getCount();
//    }
//}

import java.util.LinkedList;
import java.util.List;

public class MealRecipes implements Comparable<MealRecipes>{
    private int mealId;
    private int count;
    private List<Integer> waiterIdList;
    public MealRecipes(int mealId, int count, int waiterId) {
        this.mealId = mealId;
        this.count = count;
        this.waiterIdList = new LinkedList<>();
        this.waiterIdList.add(waiterId);
    }

    public int getMealId() {
        return mealId;
    }

    public int getCount() {
        return count;
    }

    public List<Integer> getWaiterIdList() {
        return waiterIdList;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addWaiterId(int waiterId) {
        this.waiterIdList.add(waiterId);
    }

    @Override
    public String toString() {
        return "MealRecipes{" +
                "mealId=" + mealId +
                ", count=" + count +
                ", waiterIdList=" + waiterIdList +
                '}';
    }
// look better
    //    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("mealId = ").append(mealId);
//        sb.append(", count = ").append(count);
//        sb.append(", waiterId = ");
//        for (int i = 0; i < waiterIdList.size(); i++) {
//            if (i > 0) {
//                sb.append(" and ");
//            }
//            sb.append(waiterIdList.get(i));
//        }
//        return sb.toString();
//    }

    @Override
    public int compareTo(MealRecipes mr) {
        return   mr.getCount()-this.count;
    }
}
