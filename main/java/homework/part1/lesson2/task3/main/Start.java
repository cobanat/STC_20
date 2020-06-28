package homework.part1.lesson2.task3.main;

import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.service.api.PersonFindDuplicateService;
import homework.part1.lesson2.task3.service.api.PersonGeneratorService;
import homework.part1.lesson2.task3.service.api.PersonSortService;
import homework.part1.lesson2.task3.service.impl.PersonFindDuplicateServiceImpl;
import homework.part1.lesson2.task3.service.impl.PersonGeneratorServiceImpl;
import homework.part1.lesson2.task3.service.impl.PersonSortServiceImpl;
import homework.part1.lesson2.task3.sorter.SortType;

public class Start {

    public static void main(String[] args) {
        Person[] people = new Person[10000];
        PersonGeneratorService personGeneratorService = new PersonGeneratorServiceImpl();
        personGeneratorService.fillPersonArray(people);

        PersonSortService personSortService = new PersonSortServiceImpl(people, SortType.BUBBLE);
        personSortService.sort();
        printPersonArray(people);

        PersonFindDuplicateService personFindDuplicateService = new PersonFindDuplicateServiceImpl(people);
        personFindDuplicateService.findDuplicate();
    }

    private static void printPersonArray(Person[] people) {
        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}
