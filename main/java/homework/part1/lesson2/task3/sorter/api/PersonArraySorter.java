package homework.part1.lesson2.task3.sorter.api;

import homework.part1.lesson2.task3.entity.Person;


import java.util.Comparator;

public interface PersonArraySorter {

    void sort(Person[] array, Comparator<Person> comparator);
}
