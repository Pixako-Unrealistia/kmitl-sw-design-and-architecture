//
// $Header: /home/due1/cvsreps/due/java/pattern/proxy/AbstractMap.java,v 1.1 2003-05-06 09:35:02 due Exp $
//
// Copyright (c) 2001 by Eric Dubuis,
// BFH, HTA Biel-Bienne.
// All rights reserved.

package pattern.proxy;

public interface AbstractMap {

    String find(String key) throws Exception;

    void add(String key, String value) throws Exception;

}
