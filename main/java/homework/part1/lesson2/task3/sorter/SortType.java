package homework.part1.lesson2.task3.sorter;

import homework.part1.lesson2.task3.sorter.api.PersonArraySorter;
import homework.part1.lesson2.task3.sorter.impl.BubblePersonArraySorter;
import homework.part1.lesson2.task3.sorter.impl.SelectionPersonArraySorter;

public enum SortType {

    SELECT(new SelectionPersonArraySorter()),
    BUBBLE(new BubblePersonArraySorter());

    SortType(PersonArraySorter sorter) {
        this.sorter = sorter;
    }

    private PersonArraySorter sorter;

    public PersonArraySorter getCurrentSorter() {
        return this.sorter;
    }
}
