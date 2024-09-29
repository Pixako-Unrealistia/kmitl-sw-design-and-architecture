/**
* A program that creates a cook and uses it with various meal builders
* to construct meals.
*/
public class BuilderExample {
  public static void main(String[] args) {
    Cook cook = new Cook();
    Meal meal;

    BurgerMealBuilder burgerBuilder = new BurgerMealBuilder();
    HealthyMealBuilder healthyBuilder = new HealthyMealBuilder();

    cook.setMealBuilder (burgerBuilder);
    cook.constructMeal();
    meal = cook.getMeal();
    System.out.println("Order up! A " + meal);

    cook.setMealBuilder (healthyBuilder);
    cook.constructMeal();
    meal = cook.getMeal();
    System.out.println("Order up! A " + meal);
  }
}


