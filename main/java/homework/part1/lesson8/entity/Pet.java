package homework.part1.lesson8.entity;


import java.io.Serializable;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 19.05.2020
 */
public class Pet implements Serializable {

    private String name;
    private Gender gender;
    private int age;

    public Pet(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getPetName() {
        return name;
    }

    public Gender getPetGender() {
        return gender;
    }

    public int getPetAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + name + '\'' +
                ", petGender=" + gender +
                ", petAge=" + age +
                '}';
    }
}
