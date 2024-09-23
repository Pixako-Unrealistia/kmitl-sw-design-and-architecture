//
// $Header: /home/due1/cvsreps/due/java/pattern/flyweight/IconFactory.java.templ,v 1.1 2002-05-14 09:41:25 due Exp $
//
// Copyright (c) 2002 Eric Dubuis,
// Berner Fachhochschule, HTA Biel.
// All rights reserved.
//
// Based on: J.W. Cooper, Java Design Patterns, Addison-Wesley 2000.

package pattern.flyweight;

import java.util.*;

public class IconFactory {
    private Map<String, AbstractIcon> iconmap = new HashMap<>();

    // Singleton instance
    private static IconFactory instance = new IconFactory();
    private IconFactory() {}

    public AbstractIcon createIcon(String key) {
        // Check if icon is already created
        if (iconmap.containsKey(key)) {
            return iconmap.get(key);
        }

        // Create new icon based on the key
        AbstractIcon icon = null;
        switch (key.toLowerCase()) {
            case "folder":
                icon = new FolderIcon();
                break;
            case "java":
                icon = new JavaIcon();
                break;
            case "pdf":
                icon = new PdfIcon();
                break;
            case "picture":
                icon = new PictureIcon();
                break;
            case "text":
                icon = new TextIcon();
                break;
            default:
                icon = new UnknownIcon();
                break;
        }

        iconmap.put(key, icon);
        return icon;
    }

    public static IconFactory getInstance() {
        if (instance == null) {
            instance = new IconFactory();
        }
        return instance;
    }
}
