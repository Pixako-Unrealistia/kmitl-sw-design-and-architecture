//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/FlyweightDemo.java.templ,v 1.1 2002-05-14 09:41:24 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.

package pattern.flyweight;

import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.util.*;

public class FlyweightDemo extends JFrame
    implements MouseMotionListener
{
    private ArrayList items;
    private IconFactory factory;
    private final int Top = 30, Left = 30;
    private final int  W = 50, H = 30;
    private final int VSpace = 80, HSpace=70, HCount = 3;
    private String selectedName = "";

    private class Item {
        String type;
        String name;
        AbstractIcon icon;
        Item(String type, String name, AbstractIcon icon) {
            this.type = type;
            this.name = name;
            this.icon = icon;
        }
    }

    public FlyweightDemo() {
        super("Flyweight Demo");

        setSize(new Dimension(250,300));
        JPanel jp = new JPanel();
        getContentPane().add(jp, BorderLayout.CENTER);
        addMouseMotionListener(this);
	    addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {System.exit(0);}
	    });

        loadItems();

        setVisible(true);
    }

    private void loadItems() {
        factory = IconFactory.getInstance();

        items = new ArrayList<>();
        items.add(new Item("folder", "Folder 1", factory.createIcon("folder")));
        items.add(new Item("java", "Java File 1", factory.createIcon("java")));
        items.add(new Item("picture", "Picture 1", factory.createIcon("picture")));
        items.add(new Item("text", "Text File 1", factory.createIcon("text")));
        items.add(new Item("unknown", "Unknown 1", factory.createIcon("unknown")));
        items.add(new Item("folder", "Folder 2", factory.createIcon("folder")));
        items.add(new Item("java", "Java File 2", factory.createIcon("java")));
    }


    public void paint(Graphics g) {
        super.paint(g);
        Item item;
        int j = 0;      // count number in row
        int row = Top;  // start in upper left
        int x = Left;

        // go through all the items
        for (int i = 0; i < items.size(); i++) {
            item = (Item) items.get(i);
            item.icon.draw(g, x, row, item.name, item.name.equals(selectedName));

            // Recalculation of part of the extrinsic state:
            x = x + HSpace; // change to next position
            j++;
            if (j >= HCount) { // reset for next row
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }


    public void mouseMoved(MouseEvent e) {
        int j = 0;      //count number in row
        int row = Top;  //start in upper left
        int x = Left;

        //go through all the items
        for (int i = 0; i< items.size(); i++) {
            //see if this item area contains the mouse
            Rectangle r = new Rectangle(x,row,W,H);
            if (r.contains(e.getX(), e.getY())) {
                selectedName = ((Item)items.get(i)).name;
                repaint();
            }
            x = x + HSpace;          //change to next posn
            j++;
            if (j >= HCount) {       //reset for next row
                j = 0;         
                row += VSpace;
                x = Left;
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
    }

    public static  void main(String[] args) {
        new FlyweightDemo();
    }
}
