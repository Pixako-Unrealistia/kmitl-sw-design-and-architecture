/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author boonjv
 */
/**
 * Meal models a typical fast-food chain value meal consisting of an
 * entree, a side, and a drink. 
 */
public class Meal {
  
  private String entree = ""; /** Primary dish of this meal */
  private String side = "";   /** Side dish of this meal */
  private String drink = "";  /** Drink for this meal */

  /**
   * Set the entree of this meal to the specified value.
   *
   * @param entree Specified value to set the entree of this meal to
   */
  public void setEntree(String entree) { 
    this.entree = entree;
  }

  /**
   * Set the side dish of this meal to the specified value.
   *
   * @param entree Specified value to set the side dish of this meal to
   */
  public void setSide(String side) { 
    this.side = side;
  }

  /**
   * Set the drink of this meal to the specified value.
   *
   * @param entree Specified value to set the drink of this meal to
   */
  public void setDrink(String drink) {
    this.drink = drink;
  }

  /**
   * Return a string representation of this meal indicating all portions.
   *
   * @return a String indicating all portions this meal
   */
  public String toString() {
    return entree + " with a side of " + side + " and a " + drink;
  }
}