package Collections;

import java.util.Arrays;
import java.util.List;

public class CollectionSorting {

    final private static List<Person> people = Arrays.asList(
            new Person("Andreas", 21),
            new Person("Jonas", 12),
            new Person("Bob", 30),
            new Person("Julie", 11),
            new Person("Thomas", 7),
            new Person("Anna", 24),
            new Person("Karl", 16)
    );

    public static void main(String[] args) {

        System.out.println(
                "People under 18: "
                + people.stream().filter(p -> p.getAge() <= 18).count()
        );
        System.out.println(
                "People above 18: "
                + people.stream().filter(p -> p.getAge() > 18).count()
        );

        System.out.println(
                "People named Andreas: "
                + people.stream().filter(p -> p.getName().equals("Andreas")).count()
        );

        System.out.println(
                "Number of people in list: "
                + people.stream().filter(p -> p.getClass() == Person.class).count()
        );

        System.out.println("Name of people:");
        people.forEach(p -> System.out.println(p.getName()));
        
        
    }
}
