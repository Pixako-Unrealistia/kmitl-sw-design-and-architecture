/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boonjv
 */
public class HealthyMealBuilder extends MealBuilder {
    public void buildEntree(){
        theMeal.setEntree("chicken sandwich");
    }
    public void buildSide(){
        theMeal.setSide("carrot sticks");
    }
    public void buildDrink(){
        theMeal.setDrink("diet cola");
    }
}
