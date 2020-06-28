package homework.part1.lesson8.serialization;

import homework.part1.lesson8.entity.Gender;
import homework.part1.lesson8.entity.Person;
import homework.part1.lesson8.entity.Pet;
import homework.part1.lesson8.parser.ParserToSting;
import homework.part1.lesson8.reader.ReaderObject;
import homework.part1.lesson8.writer.WriterObject;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 19.05.2020
 */
public class Serializator {

    public void serialize(Object object, String path) throws IllegalAccessException, NoSuchFieldException {
        Class<? extends Object> instanceOfPersonClass = object.getClass();
        Field[] declaredFieldsPerson = instanceOfPersonClass.getDeclaredFields();


        Field petField = instanceOfPersonClass.getDeclaredField("personPet");
        petField.setAccessible(true);
        Class<? extends Object> instanceOfPetClass = petField.get(object).getClass();
        Field[] declaredFieldsPet = instanceOfPetClass.getDeclaredFields();

        ParserToSting parser = new ParserToSting();
        String serializePersonText = parser.parse(instanceOfPersonClass, declaredFieldsPerson, object);
        String serializePetText = parser.parse(instanceOfPetClass, declaredFieldsPet, petField.get(object));
        String text = serializePersonText + serializePetText;
        WriterObject writerObject = new WriterObject();
        writerObject.write(text, path);

    }

    public Object deSerialize(String path) {
        ReaderObject readObject = new ReaderObject();
        String[] deserializeText = readObject.read(path);

        String personName = getValue("Person.name", deserializeText);
        Gender personGender = Gender.valueOf(getValue("Person.gender", deserializeText));
        int personAge = Integer.parseInt(getValue("Person.age", deserializeText));
        String petName = getValue("Pet.name", deserializeText);
        Gender petGender = Gender.valueOf(getValue("Pet.gender", deserializeText));
        int petAge = Integer.parseInt(getValue("Pet.age", deserializeText));

        Pet pet = new Pet(petName, petGender, petAge);
        return new Person(personName, personGender, personAge, pet);
    }

    private String getValue(String nameValue, String[] deserializeText) {
        for(String text : deserializeText) {
            if(text.contains(nameValue)) {
                return text.substring(text.lastIndexOf(" ") + 1);
            }
        }
        return "0";
    }
}
