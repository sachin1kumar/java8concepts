package stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream()
                .filter(num -> num % 2 == 0) /*if this is not true, thenit will remove the num from conveyor belt and return false.
                For each  will not be called in this case*/
                .forEach(num -> System.out.println(num));
    }
}
