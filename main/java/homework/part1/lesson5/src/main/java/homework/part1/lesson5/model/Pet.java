package homework.part1.lesson5.model;

import java.util.Objects;

/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public class Pet {
  private final int id;
  private final String name;
  private final Gender petGender;
  private final Person petOwner;
  private final int weight;

  public Pet(
      final int id,
      final String name,
      final Gender petGender,
      final int weight,
      final Person petOwner) {
    this.id = id;
    this.name = name;
    this.petGender = petGender;
    this.weight = weight;
    this.petOwner = petOwner;
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  public String getOwnerName() {
    return petOwner.getName();
  }

  public int getId() {
    return id;
  }

  public Gender getPetGender() {
    return petGender;
  }

  public Person getPetOwner() {
    return petOwner;
  }

  @Override
  public String toString() {
    return id + " " + name + " " + petGender + " " + weight + " | " + petOwner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pet pet = (Pet) o;
    return weight == pet.weight
        && Objects.equals(name, pet.name)
        && petGender == pet.petGender
        && Objects.equals(petOwner, pet.petOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, petGender, petOwner, weight);
  }
}
