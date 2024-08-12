package lab06.task3;
 
import lab06.task3.facade.Tea;
import lab06.task3.facade.TeaCup;
import lab06.task3.facade.TeaInfuser;
import lab06.task3.facade.Water;
import lab06.task3.TeaFacade;

public class MakeTea {
    public static void main(String[] args) {
        TeaCup blueCup = new TeaCup();
        Water water = new Water();
        TeaInfuser infuser = new TeaInfuser();
        TeaFacade teaMaker = new TeaFacade(blueCup,water,infuser);
        teaMaker.makeTea("Earl Grey");
    }
}
