package ranga;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class StringTest {

    private static final List<String> cars = List.of("Audi", "BMW", "Maruti Suzuki", "Porsche");

    public static void main(String[] args) {
        convertToUpperCase(cars);
        filterCarList(cars);
        threadCreation();
    }

    private static void convertToUpperCase(final List<String> cars) {
        final List<String> modifiedList = new ArrayList<>(cars);
        modifiedList.replaceAll(str -> str.toUpperCase(Locale.ROOT));
        System.out.println(modifiedList);
    }

    private static void filterCarList(final List<String> cars) {
        final List<String> modifiedList = new ArrayList<>(cars);
        modifiedList.removeIf(str -> str.length() > 5);
        System.out.println(modifiedList);
    }

    private static void threadCreation() {
        final Runnable runnable = () -> {
            IntStream.range(1, 90)
                    .forEach(count -> System.out.println(Thread.currentThread().getId()+": "+count));
        };

        final Thread thread = new Thread(runnable);
        thread.start();
    }
}
