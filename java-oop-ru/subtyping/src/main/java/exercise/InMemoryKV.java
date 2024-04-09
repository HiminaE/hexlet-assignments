package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage{
    private Map<String, String> data;

    public InMemoryKV(Map<String, String> data) {
        this.data = new HashMap<>(data);
    }

    public void set(String key, String value) {
        var map = new HashMap<String, String>(this.data);
        map.put(key, value);
        this.data = map;
    }

    public void unset(String key) {
        var map = new HashMap<String, String>(this.data);
        map.remove(key);
        this.data = map;
    }

    public String get(String key, String defaultValue) {
        var map = new HashMap<String, String>(this.data);
        if (map.containsKey(key)) {
            return map.get(key).toString();
        } else {
            return defaultValue;
        }
    }

    public Map<String, String> toMap() {
        return new HashMap<>(this.data);
    }
}
// END
