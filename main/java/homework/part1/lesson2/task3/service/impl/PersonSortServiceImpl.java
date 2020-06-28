package homework.part1.lesson2.task3.service.impl;

import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.service.api.PersonSortService;
import homework.part1.lesson2.task3.sorter.SortType;
import homework.part1.lesson2.task3.sorter.impl.BubblePersonArraySorter;
import homework.part1.lesson2.task3.sorter.impl.SelectionPersonArraySorter;
import homework.part1.lesson2.task3.specifier.PersonAgeSpecifier;
import homework.part1.lesson2.task3.specifier.PersonGenderSpecifier;
import homework.part1.lesson2.task3.specifier.PersonNameSpecifier;

import java.util.Comparator;

public class PersonSortServiceImpl implements PersonSortService {
    private Person[] array;
    private SortType type;

    public PersonSortServiceImpl(Person[] array, SortType type) {
        this.array = array;
        this.type = type;
    }

    @Override
    public void sort() {
        Comparator<Person> comparator = new PersonNameSpecifier()
                .thenComparing(new PersonGenderSpecifier()
                        .thenComparing(new PersonAgeSpecifier()));

        switch (type) {
            case BUBBLE:
                BubblePersonArraySorter bubblePersonArraySorter = new BubblePersonArraySorter();
                bubblePersonArraySorter.sort(array, comparator);
                break;
            case SELECT:
                SelectionPersonArraySorter selectionPersonArraySorter = new SelectionPersonArraySorter();
                selectionPersonArraySorter.sort(array, comparator);
        }
    }


}
