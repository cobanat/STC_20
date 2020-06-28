package homework.part1.lesson8;

import homework.part1.lesson8.entity.Gender;
import homework.part1.lesson8.entity.Person;
import homework.part1.lesson8.entity.Pet;
import homework.part1.lesson8.serialization.Serializator;

import java.io.IOException;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 19.05.2020
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Pet alex = new Pet("Alex", Gender.MALE, 9);
        Person jhon = new Person("Jhon", Gender.MALE, 24, alex);
        String path = "src\\main\\java\\homework\\part1\\lesson8\\object.xml";
        Serializator serializator = new Serializator();
        serializator.serialize(jhon, path);

        System.out.println(serializator.deSerialize(path).toString());
    }
}
