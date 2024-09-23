//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/PictureIcon.java.templ,v 1.1 2002-05-14 09:41:25 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.

package pattern.flyweight;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class PictureIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon icon;


    // COMPLETE.


    // We make this package-visible so that only the corresponding
    // factory can instantiate us.
    PictureIcon() {
	URL iconURL =
	    ClassLoader.getSystemResource("icons/picture.png");
	if (iconURL != null) {
	    icon = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon icons/picture.png not found");
	}
    }

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        //g.clearRect(tx, ty, icon.getIconWidth(), icon.getIconHeight());
	icon.paintIcon(null, g, tx, ty);
        g.drawString(name, tx, ty + H + 15);  //title
    }
}
