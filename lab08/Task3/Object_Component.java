import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Object_Component {
    public void add(Object_Component component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Object_Component component) {
        throw new UnsupportedOperationException();
    }

    public Object_Component getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void render();

    public abstract float volume();

    public abstract Iterator<Object_Component> createIterator();
}
