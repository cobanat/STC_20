package homework.part1.lesson5.userInterface;

import java.util.Scanner;

/** @author Nail Zinnurov cobratms@gmail.com on 06.05.2020 */
public class UserInput {
  Scanner scan = new Scanner(System.in);
  String in;

  public String input() {
    in = scan.next();
    return in;
  }
}
