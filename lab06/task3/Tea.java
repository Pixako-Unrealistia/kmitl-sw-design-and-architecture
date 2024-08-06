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
public class Tea {
	private String flavor; // i.e. "Earl Grey", "English Breakfast"	
	public Tea(String flavor) {
		this.flavor = flavor;
	}
	public String getflavor() {
		return flavor;
	}
}
