package homework.part1.lesson5.model;
/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public enum Gender {
  MALE,
  FEMALE,
  UNKNOWN;

  public static Gender findByName(String genderString) {
    for (Gender gender : Gender.values()) {
      if (gender.name().equalsIgnoreCase(genderString)) {
        return gender;
      }
    }
    return UNKNOWN;
  }
}
