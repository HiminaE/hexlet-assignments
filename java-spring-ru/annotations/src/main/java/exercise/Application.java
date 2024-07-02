package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        // Итерируем все методы класса
        for (Method method : address.getClass().getDeclaredMethods()) {

            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {

                var name = method.getName();
                var typeName = method.getReturnType().getSimpleName();
                //Если есть, то выводим на печать название и тип
                System.out.println("Method " + name + " return a value of type " + typeName);
            }
        }
        // END
    }
}
