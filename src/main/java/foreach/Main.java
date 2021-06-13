package foreach;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        //Before java8 we had external for loops like: normal and enhanced for-loop.

        //In java8
        list.forEach(index -> System.out.println(index));
    }
}
