package homework.part1.lesson5.service;

import homework.part1.lesson5.comparator.PetComparatorFactory;
import homework.part1.lesson5.model.Pet;

import java.util.*;
import java.util.stream.Collectors;

/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public class PetService {

  private final Map<Integer, Pet> petsFile = new HashMap<>();
  private final Map<String, Set<Integer>> sameNamePet = new HashMap<>();

  public boolean add(Pet pet) {
    if (searchID(pet.getId())) {
      return false;
    }
    petsFile.put(pet.getId(), pet);
    correctMapSameNamePets(pet.getId(), pet);
    return true;
  }

  public boolean changeData(int id, Pet pet) {
    if (searchID(id)) {
      String nameBeforeChange = petsFile.get(id).getName();
      sameNamePet.get(nameBeforeChange).remove(id);
      correctMapSameNamePets(id, pet);
      petsFile.put(id, pet);
      return true;
    }
    return false;
  }

  private void correctMapSameNamePets(int id, Pet pet) {
    if (!sameNamePet.containsKey(pet.getName())) {
      sameNamePet.put(pet.getName(), new HashSet<>());
    }
    sameNamePet.get(pet.getName()).add(id);
  }

  public List<Pet> search(String name) {
    List<Pet> petsFound = new ArrayList<>();
    if (sameNamePet.get(name) != null) {
      Set<Integer> list = sameNamePet.get(name);
      for (Integer id : list) {
        petsFound.add(petsFile.get(id));
      }
    }
    return petsFound;
  }

  private boolean searchID(int id) {
    return petsFile.containsKey(id);
  }

  public List<Pet> getData() {
    Comparator<Pet> comparator =
        PetComparatorFactory.byWeight()
            .thenComparing(
                PetComparatorFactory.byName().thenComparing(PetComparatorFactory.byOwnerName()));
    return petsFile.values().stream().sorted(comparator).collect(Collectors.toList());
  }
}
