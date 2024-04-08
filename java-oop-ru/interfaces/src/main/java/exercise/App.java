package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> list, int num) {
        List<String> stream = list.stream()
                .sorted(Home::compareTo)
                .map(home -> home.toString())
                .limit(num)
                .collect(Collectors.toList());
        return stream;
    }
}

// END
