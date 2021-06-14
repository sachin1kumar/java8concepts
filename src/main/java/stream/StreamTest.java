package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        Stream<Integer> stream = list.parallelStream();

        stream.forEach(System.out::println);
        //stream.forEach(System.out::println);
    }
}
