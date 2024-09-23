//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/JavaIcon.java.templ,v 1.1 2002-05-14 09:41:25 due Exp $
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

public class JavaIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon icon;

    JavaIcon() {
        URL iconURL = ClassLoader.getSystemResource("icons/source_java.png");
        if (iconURL != null) {
            icon = new ImageIcon(iconURL);
        } else {
            System.out.println("Icon icons/source_java.png not found");
        }
    }

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        g.clearRect(tx, ty, icon.getIconWidth(), icon.getIconHeight());
        icon.paintIcon(null, g, tx, ty);
        g.drawString(name, tx, ty + H + 15); // title
    }

}
