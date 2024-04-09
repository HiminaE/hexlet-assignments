package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(this);
        return result;
    }

    public static Car unserialize(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Car result = mapper.readValue(jsonString, Car.class);
        return result;
    }
    // END
}
