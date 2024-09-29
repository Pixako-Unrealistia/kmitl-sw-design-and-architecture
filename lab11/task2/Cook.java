/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boonjv
 */
/** A cook that uses a builder for a meal to actually construct a meal
 * and make it available.
 *
 * @author Jerod Weinman
 * @author YOUR NAME HERE
 */
public class Cook {

  /** A meal builder that specifies how to assemble a particular meal */
  private MealBuilder builder; 

  
  /**
   * Set the meal builder for this cook to the specified value.
   *
   * @param builder the meal builder for this cook to use
   */
  public void setMealBuilder (MealBuilder builder) {
    this.builder = builder;
  }

  /**
   * Return the meal constructed by this cook.
   *
   * @return the meal constructed by this cook.
   */
  public Meal getMeal() {
    return builder.getMeal();
  }

  
  /**
   * Uses the meal builder of this cook to construct all portions of a meal.
   */
  public void constructMeal() {
    // Take the necessary steps
    builder.createNewMeal();
    builder.buildEntree();
    builder.buildSide();
    builder.buildDrink();

  }

}