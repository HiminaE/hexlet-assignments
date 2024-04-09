package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();

        for (Field field : address.getClass().getDeclaredFields()) {
            Annotation annotation = field.getAnnotation(NotNull.class);
            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    if(field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (Exception exception){
                }
            }
        }
        return result;
    }
}
// END
