package homework.part1.lesson2.task3.sorter.impl;

import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.sorter.api.PersonArraySorter;

import java.util.Comparator;

public class SelectionPersonArraySorter implements PersonArraySorter {
    @Override
    public void sort(Person[] array, Comparator<Person> comparator) {
        int max;
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < array.length - 1; i++) {
            max = i;
            for(int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[j], array[max]) < 0) max = j;
            }
            swap(i, max, array);
        }
        double timeSort = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Sorting time: " + timeSort + " sec.");
    }

    private void swap(int i, int max, Person[] array) {
        Person human = array[i];
        array[i] = array[max];
        array[max] = human;
    }
}
