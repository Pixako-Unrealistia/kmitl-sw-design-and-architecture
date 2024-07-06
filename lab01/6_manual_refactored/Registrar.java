import java.util.HashMap;
import java.util.Map;

public class Registrar {
    private static final Map<String, Map<String, DomainObject>> STORE = new HashMap<>();

    public static void add(String type, DomainObject obj) {
        STORE.computeIfAbsent(type, k -> new HashMap<>()).put(obj.name(), obj);
    }

    public static DomainObject get(String type, String name) {
        return STORE.getOrDefault(type, new HashMap<>()).get(name);
    }
}