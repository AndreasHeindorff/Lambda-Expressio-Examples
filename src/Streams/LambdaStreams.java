package Streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class LambdaStreams {

    final private static List<Person> dotNetProgrammers = Arrays.asList(
            new Person("Elsdon", "Jaycob", "C# .NET Programmer", "male", 43, 2000),
            new Person("Tamsen", "Brittany", "C# .NET Programmer", "female", 23, 1500),
            new Person("Floyd", "Donny", "C# .NET Programmer", "male", 33, 1800),
            new Person("Sindy", "Jonie", "C# .NET Programmer", "female", 32, 1600),
            new Person("Vere", "Hervey", "C# .NET Programmer", "male", 22, 1200),
            new Person("Maude", "Jaimie", "C# .NET Programmer", "female", 27, 1900),
            new Person("Shawn", "Randall", "C# .NET Programmer", "male", 30, 2300),
            new Person("Jayden", "Corrina", "C# .NET Programmer", "female", 35, 1700),
            new Person("Palmer", "Dene", "C# .NET Programmer", "male", 33, 2000),
            new Person("Addison", "Pam", "C# .NET Programmer", "female", 34, 1300)
    );

    final private static List<Person> javaProgrammers = Arrays.asList(
            new Person("Elsdon", "Andreas", "Java programmer", "male", 43, 2000),
            new Person("Tamsen", "Jonas", "Java programmer", "female", 23, 1500),
            new Person("Floyd", "Christian", "Java programmer", "male", 33, 1800),
            new Person("Sindy", "Bob", "Java programmer", "female", 32, 1600),
            new Person("Vere", "Carl", "Java programmer", "male", 22, 1200),
            new Person("Maude", "Maggie", "Java programmer", "female", 27, 1900),
            new Person("Shawn", "Michael", "Java programmer", "male", 30, 2300),
            new Person("Jayden", "Emil", "Java programmer", "female", 35, 1700),
            new Person("Palmer", "Sonja", "Java programmer", "male", 33, 2000),
            new Person("Addison", "Tessa", "Java programmer", "female", 34, 1300)
    );

    Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
    Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
    Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

    void forEachIterate() {
        System.out.println("Show programmers names:");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        dotNetProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    void increaseSalary() {
        System.out.println("Increase salary by 5% to programmers:");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        dotNetProgrammers.forEach(giveRaise);
    }

    void filterSalary() {
        System.out.println("Show C#.NET programmers that earn more than $1,400:");
        dotNetProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    void Filters() {
        System.out.println("Show female C#.NET programmers that earn more than $1,400 and are older than 24 years:");
        dotNetProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        System.out.println("Show female Java programmers older than 24 years:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    void Limit() {
        System.out.println("Show first 3 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        System.out.println("Show first 3 female Java programmers:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }

    void Sorting() {
        System.out.println("Sort and show the first 5 Java programmers by name:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("Sort and show Java programmers by salary:");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));
    }

    void MinMax() {
        System.out.println("Get the lowest Java programmer salary:");
        Person pers = javaProgrammers
                .stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("Get the highest Java programmer salary:");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
    }

    void Collect() {
        System.out.println("Get C#.NET programmers first name to String:");
        String dotNetDevelopers = dotNetProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining(" ; "));    // this can be used as a token in further operations

        System.out.println("Get Java programmers first name to Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());
    }

    void Parallel() {
        System.out.println("Calculate total money spent for paying Java programmers:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();
    }

    void SummaryStatistics() {
        //Get count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
    
    public static void main(String[] args) {
        LambdaStreams ls = new LambdaStreams();
        ls.forEachIterate();
        ls.increaseSalary();
        ls.filterSalary();
        ls.Filters();
        ls.Limit();
        ls.Sorting();
        ls.MinMax();
        ls.Collect();
        ls.Parallel();
        ls.SummaryStatistics();
        
    }

}
