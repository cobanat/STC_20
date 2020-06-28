package homework.part1.lesson5.comparator;

import homework.part1.lesson5.model.Pet;

import java.util.Comparator;

public class PetComparatorFactory {

  public static Comparator<Pet> byName() {
    return Comparator.comparing(Pet::getName);
  }

  public static Comparator<Pet> byOwnerName() {
    return Comparator.comparing(Pet::getOwnerName);
  }

  public static Comparator<Pet> byWeight() {
    return Comparator.comparingInt(Pet::getWeight);
  }
}
