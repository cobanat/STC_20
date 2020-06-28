package homework.part1.lesson2.task3.sorter.impl;

import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.sorter.api.PersonArraySorter;

import java.util.Comparator;

public class BubblePersonArraySorter implements PersonArraySorter {
    @Override
    public void sort(Person[] array, Comparator<Person> comparator) {
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < array.length; i++) {
            for(int j = i+1; j < array.length; j++) {
                if(comparator.compare(array[i], array[j]) > 0) swap(i, j, array);
            }
        }
        double timeSort = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Sorting time: " + timeSort + " sec.");
    }

    private void swap(int i, int j, Person[] array) {
        Person human = array[i];
        array[i] = array[j];
        array[j] = human;
    }
}
