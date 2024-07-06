import java.util.HashMap;

public class Registrar {
    private static final HashMap<String, HashMap<String, DomainObject>> store = new HashMap<>();

    public static void add(String type, DomainObject obj) {
        store.computeIfAbsent(type, k -> new HashMap<>()).put(obj.name(), obj);
    }

    public static DomainObject get(String type, String name) {
        return store.getOrDefault(type, new HashMap<>()).get(name);
    }
}