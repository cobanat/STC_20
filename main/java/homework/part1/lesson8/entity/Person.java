package homework.part1.lesson8.entity;

import java.io.Serializable;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 19.05.2020
 */
public class Person implements Serializable {

    private String name;
    private Gender gender;
    private int age;
    private Pet personPet;

    public Person(String name, Gender gender, int age, Pet personPet) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.personPet = personPet;
    }

    public String getPersonName() {
        return name;
    }

    public Gender getPersonGender() {
        return gender;
    }

    public int getPersonAge() {
        return age;
    }

    public Pet getPersonPet() {
        return personPet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", pet=" + personPet +
                '}';
    }
}
