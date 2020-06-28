package homework.part1.lesson5.model;

import java.util.Objects;

/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public class Person {
  private final String name;
  private final int age;
  private final Gender personGender;

  public Person(final String name, final int age, final Gender personGender) {
    this.name = name;
    this.age = age;
    this.personGender = personGender;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Gender getPersonGender() {
    return personGender;
  }

  @Override
  public String toString() {
    return name + " " + age + " " + personGender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age
        && Objects.equals(name, person.name)
        && personGender == person.personGender;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, personGender);
  }
}
