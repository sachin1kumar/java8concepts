package ranga;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceExercise {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        findFunctionalInterface(integerList);
        doBehaviorParam(integerList);
    }

    //Exercise 11: Find Functional Interface behind the second argument of reduce method.
    // Create an implementation for the Functional Interface.
    //int sum = numbers.stream() .reduce(0, Integer::sum);
    private static void findFunctionalInterface(List<Integer> integerList) {

        BinaryOperator<Integer> integerBinaryOperator = Integer::sum;

        BinaryOperator<Integer> integerBinaryOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        };

        System.out.println(integerList.stream()
                //.reduce(0, Integer::sum)
                .reduce(0, integerBinaryOperator1));
    }

    //Excercise: 13, Do Behavior Parameterization for the mapping logic.
    //List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
    private static void doBehaviorParam(List<Integer> integerList) {
        System.out.println("-----------Exercise 13---------------");
        customGenericMethod(integerList, num -> num * num);
        customGenericMethod(integerList, num -> num * num * num);
    }

    private static void customGenericMethod(List<Integer> integerList, Function<Integer, Integer> function) {
        final List squaredNumbers = integerList.stream()
                .map(function) .collect(Collectors.toList());
        //print
        squaredNumbers.stream().forEach(System.out::println);
    }
}
