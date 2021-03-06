package homework.part1.lesson2.task3.specifier;

import homework.part1.lesson2.task3.entity.Person;

import java.util.Comparator;

public class PersonAgeSpecifier implements Comparator<Person> {

    public int compare(Person a, Person b) {
        return Integer.compare(b.getAge(), a.getAge());
    }

}
