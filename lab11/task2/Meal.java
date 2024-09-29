
/**
 * Meal models a typical fast-food chain value meal consisting of an
 * entree, a side, and a drink. 
 */
public class Meal {
  private String entree = ""; /** Primary dish of this meal */
  private String side = "";   /** Side dish of this meal */
  private String drink = "";  /** Drink for this meal */

  // Set the entree of this meal to the specified value.
  public void setEntree(String entree) { 
    this.entree = entree;
  }

  //Set the side dish of this meal to the specified value.
  public void setSide(String side) { 
    this.side = side;
  }

  // Set the drink of this meal to the specified value.
  public void setDrink(String drink) {
    this.drink = drink;
  }

  //Return a string representation of this meal indicating all portions.
  public String toString() {
    return entree + " with a side of " + side + " and a " + drink;
  }
}
