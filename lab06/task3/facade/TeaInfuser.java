/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06.task3.facade;

/**
 *
 * @author boonjv
 */
public class TeaInfuser {
    private static final int INFUSE_TIME = 5;
	private Tea tea;
	public void addTea(Tea tea) {
        int x = 0;
		this.tea = tea;
		System.out.print("Adding " + tea.getflavor() + " to the infuser for 5 seconds");
		try { 
            while (x < INFUSE_TIME) {
                System.out.print(".");
                Thread.sleep(1000);
                x++;
            }
        } catch (InterruptedException ie) { }
        finally {
            System.out.println();
        }
	}
}
