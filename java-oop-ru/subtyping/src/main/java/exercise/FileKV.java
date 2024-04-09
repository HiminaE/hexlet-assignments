package exercise;

import java.util.HashMap;
import java.util.Map;
import static exercise.Utils.readFile;
import static exercise.Utils.writeFile;
import static exercise.Utils.serialize;
import static exercise.Utils.unserialize;

// BEGIN
class FileKV implements KeyValueStorage{
    private String path;
    private Map<String, String> data;

    public FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.data.entrySet().stream()
                .forEach(n -> set(n.getKey(),n.getValue()));
    }
    @Override
    public void set(String key, String value) {
        String content = readFile(this.path);
        Map<String,String> map = unserialize(content);
        map.put(key, value);
        writeFile(path, serialize(map));
    }
    @Override
    public void unset(String key) {
        String content = readFile((this.path));
        Map <String, String> map = unserialize(content);
        map.remove(key);
        writeFile(path,serialize(map));
    }
    @Override
    public String get(String key, String defaultValue) {
        String content = readFile(this.path);
        Map <String, String> map = unserialize(content);
        return map.getOrDefault(key, defaultValue);
    }
    @Override
    public Map<String, String> toMap() {
        String content = readFile(this.path);
        Map<String, String> map = unserialize(content);
        return map;
    }
}
// END
