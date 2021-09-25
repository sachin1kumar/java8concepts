package ranga;

import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        //Numbers
        List<Integer> integerList = List.of(23, 21, 12, 4, 9, 1, 2);
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
}
