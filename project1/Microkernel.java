import java.util.HashMap;
import java.util.Map;

class Microkernel {
    private Map<String, Plugin> plugins = new HashMap<>();

    public void registerPlugin(String name, Plugin plugin) {
        plugins.put(name, plugin);
        plugin.initialize();
    }

    public String executePlugin(String name) {
        Plugin plugin = plugins.get(name);
        if (plugin != null) {
            return plugin.execute();
        } else {
            return "Plugin not found: " + name;
        }
    }

    public Plugin getPlugin(String name) {
        return plugins.get(name);
    }
}

interface Plugin {
    void initialize();

    String execute();
}
