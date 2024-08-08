package lab06.task3;
 
import lab06.task3.facade.Tea;
import lab06.task3.facade.TeaCup;
import lab06.task3.facade.TeaInfuser;
import lab06.task3.facade.Water;

public class MakeTea {
    public static void main(String[] args) {
        TeaCup blueCup = new TeaCup();
        Water water = new Water();
        TeaInfuser infuser = new TeaInfuser();
        Tea tea = new Tea("Eral Grey");
        infuser.addTea(tea);
        water.boilWater();
        blueCup.addWater(water);
        blueCup.setSteepTime(15);
        blueCup.steep();
    }
}
