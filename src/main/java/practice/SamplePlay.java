package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SamplePlay {

    public static void main(String[] args) {
        List<Integer> elements = List.of(2, 1, 2, 5, 7, 7);
        //remove duplicates from list.
        List<Integer> modifiedList = removeDuplicates(elements);
        printList(modifiedList);
        printPersonByName();
        optionalTest();
        arrayListTest();
    }

    private static List<Integer> removeDuplicates(List<Integer> elements) {
        return elements.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static void printList(List<Integer> modifiedList) {
        System.out.println("--------Remove duplicates------------");
        modifiedList.forEach(System.out::println);
        ArrayList<String> arrayList = new ArrayList<>();// or without string

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        for(int i =0 ; i< arrayList.size(); i++) {
            arrayList.remove(i);
        }

        System.out.println(arrayList); //[B, D]
    }

    private static void printPersonByName() {
        Person firstPerson = new Person();
        firstPerson.setName("Sachin");
        firstPerson.setId(123);

        Person secondPerson = new Person();
        secondPerson.setName("Kumar");
        secondPerson.setId(1234);

        List<Person> personList = new ArrayList<>();
        personList.add(firstPerson);
        personList.add(secondPerson);

        List<String> listName = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        //print
        listName.stream().forEach(System.out::println);
    }

    private static void optionalTest() {
        String[] words = new String[10];
        Optional<String> checkNull =
                Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        } else
            System.out.println("word is null");
    }

    private static void arrayListTest() {
        Person firstPerson = new Person();
        firstPerson.setName("Sachin");
        firstPerson.setId(123);

        Person secondPerson = new Person();
        secondPerson.setName("Kumar");
        secondPerson.setId(1234);

        TreeMap<Person, String> treeMap = new TreeMap<>();
        treeMap.put(firstPerson, "Test");
        treeMap.put(secondPerson, "Test1");


    }
}
