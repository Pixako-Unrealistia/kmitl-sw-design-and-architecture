/** Concrete builder for a meal with a burger, fries, and a cola. */
public class BurgerMealBuilder extends MealBuilder {
    public void buildEntree(){
        theMeal.setEntree("burger");
    }
    public void buildSide(){
        theMeal.setSide("fries");
    }
    public void buildDrink(){
        theMeal.setDrink("cola");
    }
}
