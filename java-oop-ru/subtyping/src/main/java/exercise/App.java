package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage data) {
        var map = data.toMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            var value = entry.getKey();
            var key = entry.getValue();
            data.unset(entry.getKey());
            data.set(key, value);
        }
        data = new InMemoryKV(map);
    }
}
// END
