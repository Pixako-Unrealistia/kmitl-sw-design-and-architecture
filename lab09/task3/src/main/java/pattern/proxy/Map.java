//
// $Header: /home/due1/cvsreps/due/java/pattern/proxy/Map.java,v 1.1 2003-05-06 09:35:03 due Exp $
//
// Copyright (c) 2001 by Eric Dubuis,
// BFH, HTA Biel-Bienne.
// All rights reserved.

package pattern.proxy;

import java.io.*;
import java.util.*;

public class Map implements AbstractMap {

	private String fileName;
	private final String header = " -- Generated file, do not edit --";

	public Map(String fileName) {
		this.fileName = fileName;
		File file = new File(fileName);
		// Ensure that the file exists.
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String find(String key) throws IOException {
		// Open the file, look up the value of the key
		// given, then close it.
		try (InputStream is = new FileInputStream(fileName)) {
			Properties props = new Properties();
			props.load(is);
			return props.getProperty(key);
		}
	}

	@Override
	public void add(String key, String value) throws IOException {
		// Open the file, look up the value of the key
		// given, then close it.
		Properties props = new Properties();
		try (InputStream is = new FileInputStream(fileName)) {
			props.load(is);
		}
		props.setProperty(key, value);
		try (OutputStream os = new FileOutputStream(fileName)) {
			props.store(os, header);
		}
	}
}
