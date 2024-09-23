//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/FolderIcon.java,v 1.1 2002-05-14 09:41:24 due Exp $
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

public class FolderIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon iconSel;
    private ImageIcon iconUnsel;

    // We make this package-visible so that only the corresponding
    // factory can instantiate us.
    FolderIcon() {
	URL iconURL =
	    ClassLoader.getSystemResource("icons/folder_open.png");
	if (iconURL != null) {
	    iconSel = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon icons/folder_open.png not found");
	}
	iconURL =
	    ClassLoader.getSystemResource("icons/folder.png");
	if (iconURL != null) {
	    iconUnsel = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon icons/folder.png not found");
	}
    }

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        g.clearRect(tx, ty, iconSel.getIconWidth(), iconSel.getIconHeight());
        g.clearRect(tx, ty, iconUnsel.getIconWidth(), iconUnsel.getIconHeight());
	if (sel) {
	    iconSel.paintIcon(null, g, tx, ty);
	} else {
	    iconUnsel.paintIcon(null, g, tx, ty);
	}
        g.drawString(name, tx, ty + H + 15);  //title
    }
}
