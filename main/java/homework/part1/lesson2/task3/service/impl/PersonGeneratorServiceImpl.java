package homework.part1.lesson2.task3.service.impl;


import homework.part1.lesson2.task3.entity.Person;
import homework.part1.lesson2.task3.entity.PersonGenderType;
import homework.part1.lesson2.task3.service.api.PersonGeneratorService;

import java.util.Random;

public class PersonGeneratorServiceImpl implements PersonGeneratorService {

    private static final String[] PERSON_BIRTH_MONTH = {"Август", "Вгустин", "Гарам", "Мегафон", "Лаким", "Александра", "Леха", "Альберт",
            "Евгений", "Фаулер", "Кондратий", "Ислам", "Генадий", "Антоний", "Анфим"};

    @Override
    public void fillPersonArray(Person[] array) {
        String[] personName = PERSON_BIRTH_MONTH;
        Random rnd = new Random();
        PersonGenderType[] personPersonGenderTypes = PersonGenderType.values();
        String name;
        int age;
        PersonGenderType personGenderType;
        for (int i = 0; i < array.length; i++) {
            age = rnd.nextInt(101);
            name = personName[rnd.nextInt(personName.length)];
            personGenderType = personPersonGenderTypes[rnd.nextInt(personPersonGenderTypes.length)];
            array[i] = new Person(name, personGenderType, age);
        }
    }
}
