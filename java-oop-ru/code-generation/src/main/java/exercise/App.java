package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

// BEGIN
class App {
    public static void save(Path path, Car car) throws IOException {
        String json = car.serialize();
        Files.write(path, Collections.singleton(json), StandardCharsets.UTF_8);
    }

    public static Car extract(Path path) throws IOException {
        String str = Files.readString(path);
        var result = Car.unserialize(str);
        return result;
    }
}
// END
