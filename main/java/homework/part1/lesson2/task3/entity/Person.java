package homework.part1.lesson2.task3.entity;

public class Person {
    private int age;
    private PersonGenderType personPersonGenderType;
    private String name;

    public Person(String name, PersonGenderType personPersonGenderType, int age) {
        this.name = name;
        this.personPersonGenderType = personPersonGenderType;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public PersonGenderType getPersonPersonGenderType() {
        return personPersonGenderType;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + personPersonGenderType;
    }
}
