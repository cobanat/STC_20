package homework.part1.lesson5.userInterface;

import homework.part1.lesson5.model.Gender;
import homework.part1.lesson5.model.Person;
import homework.part1.lesson5.model.Pet;
import homework.part1.lesson5.service.PetService;

import java.util.List;
import java.util.Random;

/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public class Menu {

  private final UserInput user = new UserInput();
  private final PetService cardFile = new PetService();

  public void start() {
    String choice = null;

    while (!"exit".equalsIgnoreCase(choice)) {
      showActions();

      choice = user.input();

      switch (choice) {
        case "1":
          newPet();
          break;
        case "2":
          searchPet();
          break;
        case "3":
          changePetData();
          break;
        case "4":
          showPetList();
          break;
        case "exit":
          break;
        default:
          System.out.println("Wrong input!");
          break;
      }
    }
  }

  private void newPet() {
    Random random = new Random();
    int petID = random.nextInt(1000);
    Pet pet = enterDataPet(petID);
    if (cardFile.add(pet)) {
      System.out.println("Done!");
    } else {
      System.out.println("Such a pet already exists!");
    }
  }

  private void searchPet() {
    System.out.println("Enter pet name:");
    List<Pet> petsFound = cardFile.search(user.input());

    if (petsFound.size() > 0) {
      for (Pet pets : petsFound) {
        System.out.println(pets.toString());
      }
    } else {
      System.out.println("Not found");
    }
  }

  private void changePetData() {
    System.out.println("Enter pet id:");
    int id = convertToInt();
    Pet pet = enterDataPet(id);
    if (cardFile.changeData(id, pet)) {
      System.out.println("Done!");
    } else {
      System.out.println("Pet not found");
    }
  }

  private void showPetList() {
    List<Pet> dataPet = cardFile.getData();
    if (dataPet.size() > 0) {
      for (Pet data : dataPet) {
        System.out.println(data);
      }
    } else {
      System.out.println("Pets card file is empty!");
    }
  }

  private Pet enterDataPet(int petID) {

    System.out.println("Enter pet name:");
    String petName = user.input();

    System.out.println("Enter gender pet (male/female):");
    Gender petGender = Gender.findByName(user.input());

    System.out.println("Enter weight pet: ");
    int petWeight = convertToInt();

    System.out.println("Enter name owner:");
    String nameOwner = user.input();

    System.out.println("Enter age owner:");
    int ageOwner = convertToInt();

    System.out.println("Enter gender owner (male/female):");
    Gender personGender = Gender.findByName(user.input());

    Person person = new Person(nameOwner, ageOwner, personGender);
    return new Pet(petID, petName, petGender, petWeight, person);
  }

  private int convertToInt() {
    int num = -1;
    do {
      try {
        num = Integer.parseInt(user.input());
      } catch (NumberFormatException e) {
        System.out.println("Enter only positive numbers!");
      }
    } while (num < 0);
    return num;
  }

  private void showActions() {
    System.out.println();
    System.out.println("Select an action :");
    System.out.println("1. Add new pet");
    System.out.println("2. Search pet");
    System.out.println("3. Change pet data");
    System.out.println("4. Show pet list");
    System.out.println("Or write \"exit\"");
  }
}
