
/** Abstract builder for the Meal objects, supporting all the
 *  operations for building a meal.
 */
public abstract class MealBuilder {
  protected Meal theMeal;
  
  public Meal getMeal(){
    return theMeal;
  }

  public void createNewMeal(){
    theMeal = new Meal();
  }

  public abstract void buildEntree();
  public abstract void buildSide();
  public abstract void buildDrink();

}
