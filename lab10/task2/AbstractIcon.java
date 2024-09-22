//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/AbstractIcon.java,v 1.1 2002-05-14 09:41:24 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.

package pattern.flyweight;

import java.awt.Graphics;

public abstract class AbstractIcon {

    public abstract void
	draw(Graphics g, int tx, int ty, String name, boolean selected);
}
