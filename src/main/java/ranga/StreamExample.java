package ranga;

import java.util.List;
import java.util.Optional;

public class StreamExample {

    public static void main(String[] args) {
        //Numbers
        List<Integer> integerList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //Courses
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure",
                "Docker", "Kubernetes");



        integerList.stream().forEach(StreamExample::printNumber); //:: is method reference used
        //for only static method and this is declarative approach.
        System.out.println("-----------------------");
        integerList.stream()
                //.filter(StreamExample::isEven)
                .filter(number -> number % 2 == 0) //lamda expression to simply the method definition.
                .forEach(StreamExample::printNumber); //for each will be called only when isEven returns us true.
        System.out.println("-----------Odd Nums------------");
        printOddNumber(integerList);
        System.out.println("-----------Courses------------");
        printCourses(courses);
        System.out.println("-----------Courses With Spring------------");
        printCourseContainsSpring(courses);
        System.out.println("-----------Courses With atleast 4 chars------------");
        printCourseContainsFourCharsAtleast(courses);
        System.out.println("-----------Cubes of odd nums------------");
        printCubesOfOddNums(integerList);
        System.out.println("-----------Length of Char in each course------------");
        printNumberOfCharsInEachCourse(courses);
        System.out.println("-----------Calculate sum using reduce------------");
        calculateSum(integerList);
        squareAndSum(integerList);
        cubeAndSum(integerList);
        sumOfOddNums(integerList);
    }


    private static void printNumber(int number) {
        System.out.println(number);
    }

    private static void printOddNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(StreamExample::printNumber); // here calling custom static method using metd. ref.
    }

    private static void printCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printCourseContainsSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCourseContainsFourCharsAtleast(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNums(List<Integer> integerList) {
        integerList.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }

    private static void printNumberOfCharsInEachCourse(List<String> courses) {
        courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    //calculate the sum using reduce method in which we specify the initial sum i.e. 0 and reduce all the elements
    //to a given sum
    private static void calculateSum(List<Integer> integerList) {
         System.out.println(integerList.stream()
                 //.reduce(0, StreamExample::findSum)
                 //.reduce(0, (x, y) -> x + y)
                 .reduce(0, Integer::sum)); //This is static method in Integer class..
    }

    private static int findSum(int first, int second) {
        return first + second;
    }

    //Square every number in a list and find the sum of squares
    private static void squareAndSum(List<Integer> integerList) {
        System.out.println("-----------Exercise 7------------");
        final Integer sum = integerList.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    //Cube every number in a list and find the sum of cubes
    private static void cubeAndSum(List<Integer> integerList) {
        System.out.println("-----------Exercise 8------------");
        final Integer sum = integerList.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    //Find Sum of Odd Numbers in a list
    private static void sumOfOddNums(List<Integer> integerList) {
        System.out.println("-----------Exercise 9------------");
        final Integer sum = integerList.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
