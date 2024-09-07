import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Object extends Object_Component {
    private List<Object_Component> components = new ArrayList<>();

    public void add(Object_Component component) {
        components.add(component);
    }

    public void remove(Object_Component component) {
        components.remove(component);
    }

    public Object_Component getChild(int i) {
        return components.get(i);
    }

    public void render() {
        for (Object_Component component : components) {
            component.render();
        }
    }

    public float volume() {
        float totalVolume = 0.0f;
        for (Object_Component component : components) {
            totalVolume += component.volume();
        }
        return totalVolume;
    }

    public Iterator<Object_Component> createIterator() {
        return new CompositeIterator(components.iterator());
    }
}
