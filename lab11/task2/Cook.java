/** A cook that uses a builder for a meal to actually construct a meal
 * and make it available.
 */
public class Cook {
  //A meal builder that specifies how to assemble a particular meal
  private MealBuilder builder; 

  //Set the meal builder for this cook to the specified value.
  public void setMealBuilder (MealBuilder builder) {
    this.builder = builder;
  }

  // Return the meal constructed by this cook.
  public Meal getMeal() {
    return builder.getMeal();
  }

  //Uses the meal builder of this cook to construct all portions of a meal.
  public void constructMeal() {
    // Take the necessary steps
    builder.createNewMeal();
    builder.buildEntree();
    builder.buildSide();
    builder.buildDrink();

  }
}
