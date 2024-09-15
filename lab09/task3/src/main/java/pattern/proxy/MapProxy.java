package pattern.proxy;

import java.util.HashMap;

public class MapProxy implements AbstractMap {

    private String fileName;
    private Map map = null;
    private HashMap<String, String> hashtable = new HashMap<>();

    public MapProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized String find(String key) throws Exception {
        // Check in the cache first
        String value = get(key);
        if (value != null) {
            return value;
        }
        // Fetch from Map if not in cache and update cache
        value = getMap().find(key);
        if (value != null) {
            put(key, value);
        }
        return value;
    }

    @Override
    public synchronized void add(String key, String value) throws Exception {
        // Update both the underlying map and the cache
        getMap().add(key, value);
        put(key, value);
    }

    private Map getMap() {
        if (map == null) {
            map = new Map(fileName);
        }
        return map;
    }

    private String get(String key) {
        return hashtable.get(key);
    }

    private void put(String key, String value) {
        hashtable.put(key, value);
    }
}
