/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author boonjv
 */
/** Abstract builder for the Meal objects, supporting all the
 *  operations for building a meal.
 *
 * @author YOUR NAME HERE
 */
public abstract class MealBuilder {

  protected Meal theMeal;

  // Additional methods here
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