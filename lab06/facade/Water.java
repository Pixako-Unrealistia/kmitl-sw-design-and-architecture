/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author boonjv
 */
public class Water {
    private static final int BOIL_TIME = 20;
	int x = 0;
	// simulate boiling water
	public void boilWater() {
		System.out.print("Boiling water for 20 seconds ");
		try {
            while (x < BOIL_TIME) {
                System.out.print(".");
                x++;
                Thread.sleep(1000);
            }
		}
		catch (InterruptedException ie) { }
        finally {
            System.out.println();
        }
	}
}
