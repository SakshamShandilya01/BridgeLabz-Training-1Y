
interface MealPlan {
    String getMealType();
}


class VegetarianMeal implements MealPlan {
    public String getMealType() { return "Vegetarian Meal"; }
}

class VeganMeal implements MealPlan {
    public String getMealType() { return "Vegan Meal"; }
}

class KetoMeal implements MealPlan {
    public String getMealType() { return "Keto Meal"; }
}


class Meal<T extends MealPlan> {
    T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    public void showMeal() {
        System.out.println(meal.getMealType());
    }
}


public class Main {


    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generated: " + meal.getMealType());
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> veg = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());

        veg.showMeal();
        vegan.showMeal();

        generateMeal(new KetoMeal());
    }
}