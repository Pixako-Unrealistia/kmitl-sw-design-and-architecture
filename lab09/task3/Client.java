//
// $Header: /home/due1/cvsreps/due/java/pattern/proxy/Client.java,v 1.1 2003-05-06 09:35:02 due Exp $
//
// Copyright (c) 2001 by Eric Dubuis,
// BFH, HTA Biel-Bienne.
// All rights reserved.


// Usage: java patterns.proxy.Client


package pattern.proxy;

import java.util.Date;

public class Client {

    private static String fileName;
    private final static int COUNT = 10000;

    public static void main (String[] args) {

	// Determine file name for properties file.
	String sep = System.getProperty("file.separator");
	if (sep.equals("/")) {
	    // assume we are on Unix.
	    fileName = "/tmp/key_values";
	} // end of if (sep.equals("/"))
	else {
	    // Assume we are on Windows.
	    fileName = "C:\\TEMP\\key_values";
	} // end of else

	System.out.println
	    ("Notice that file "+fileName+" is used to store key-value pairs.\n");

	// Performance test.
	AbstractMap map;
	String key = "name";
	String value = "Eric Dubuis";

	// Testing raw access to properties file.
	System.out.println("Accessing "+COUNT+" times a Map object:");

	try {
	    map = new Map(fileName);
	    map.add("name", value);
	    System.out.println("  Starting loop at: " + new Date().toString());
	    for (int i = 0; i < COUNT; i++) {
		map.find("name");
	    } // end of for (int i = 0; i < COUNT; i++)
	    System.out.println("  Finished loop at: " + new Date().toString()+"\n");

	    // Testing raw access to properties file.
	    System.out.println("Accessing "+COUNT+" times a Map proxy object:");

	    map = new MapProxy(fileName);
	    map.add("name", value);
	    System.out.println("  Starting loop at: " + new Date().toString());
	    for (int i = 0; i < COUNT; i++) {
		map.find("name");
	    } // end of for (int i = 0; i < COUNT; i++)
	    System.out.println("  Finished loop at: " + new Date().toString());

	} catch (Exception e) {
	    e.printStackTrace();
	}

    } // end of main ()

}
