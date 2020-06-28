package homework.part1.lesson2.task3.service.impl;

import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.service.api.PersonFindDuplicateService;
import homework.part1.lesson2.task3.specifier.PersonAgeSpecifier;
import homework.part1.lesson2.task3.specifier.PersonNameSpecifier;

import java.util.Comparator;

public class PersonFindDuplicateServiceImpl implements PersonFindDuplicateService {

    private Person[] array;

    public PersonFindDuplicateServiceImpl(Person[] array) {
        this.array = array;
    }
    @Override
    public void findDuplicate() {

        Comparator<Person> comparatorName = new PersonNameSpecifier().thenComparing(new PersonAgeSpecifier());

        int countDuplicate = 0;
        System.out.println("_____________________________________");
        for(int i = 0; i < array.length - 1; i++) {
            if(comparatorName.compare(array[i], array[i+1]) == 0) {
//                System.out.print(array[i].getName() + " " + array[i].getAge() + " : ");
//                System.out.println(array[i + 1].getName() + " " + array[i + 1].getAge());
                countDuplicate++;

            }
        }

        System.out.println("Duplicate Persons: " + countDuplicate);
    }
}
