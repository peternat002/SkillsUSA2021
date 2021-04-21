/* NP EAHS - PROJECT 2
Program #2 Project:
Grade Program Project 
*/

import java.util.ArrayList;
import java.util.Scanner;

class Proj2 {
  public static void main(String[] args) {
    System.out.println("\n--//Project 2- Grade Program- Natalie Petersen//--\n");

    // create each list of scores. add these arraylists to a bigger arraylist
    // containing them (easier to step through later)
    ArrayList<Double> progList = new ArrayList<Double>();
    ArrayList<Double> artList = new ArrayList<Double>();
    ArrayList<Double> sciList = new ArrayList<Double>();
    ArrayList<Double> mathList = new ArrayList<Double>();
    ArrayList<Double> histList = new ArrayList<Double>();

    ArrayList<ArrayList> classList = new ArrayList<ArrayList>();
    classList.add(progList);
    classList.add(artList);
    classList.add(sciList);
    classList.add(mathList);
    classList.add(histList);

    String[] classes = { "Programming", "Art", "Science", "Math", "History" }; // for printing class names in a loop
    Scanner sc = new Scanner(System.in); // for user inputs in console

    // initialize student# and exit ... number of students is redundant to size of
    // each array but is useful for printing student # at the start of each
    // iteration.
    int numStudents = 1;
    boolean exit = false;
    System.out.println("Please enter student scores for the following five classes.");

    // loop will continue to run until exit is selected.
    while (!exit) {
      System.out.println("\nStudent #" + numStudents);
      // for each class in classes, ask for a grade. ensure grade input is valid, then
      // add grade to the class it belongs to (programming, history, etc)
      for (int i = 0; i < classes.length; i++) {
        String class_ = classes[i];

        // following is adapted from the first project.
        boolean accepted = false;
        String badCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-=_+[]\\{}|;:\"\',<>/?~`";
        String answer = "";

        // ensures input is not empty, not letters, not negative
        while (!accepted) {
          System.out.print(class_ + " Grade: ");
          answer = sc.nextLine().trim();

          if (answer.length() == 0) {
            System.out.println("No input received. Please try again.");
          } else {
            int countBad = 0;
            // counts number of bad characters found. also catches negatives as - is found.
            for (int j = 0; j < badCharacters.length(); j++) {
              if (answer.contains(badCharacters.substring(j, j + 1))) {
                countBad++;
              }
            }
            if (countBad > 0) {
              if (answer.contains("-"))
                System.out.print("Input must not be negative.");
              else
                System.out.print("Input must not contain letters or other non-number characters.");
              System.out.print(" Please try again.\n");
            } else {
              if (Double.parseDouble(answer.trim()) >= 0 && Double.parseDouble(answer.trim()) <= 100) {
                accepted = true;
              }

              else {
                System.out.println("Input must be between scores 0 and 100. Please try again.");
              }
            }
          }
          // end of accepted loop
        } // input is a number, either int or double. and is >0, <100

        // adds score to the correct list.
        double score = Double.parseDouble(answer.trim());
        classList.get(i).add(score);
      } // end of per-class loop

      System.out.println("\nOptions to continue: Calculate (or press 1), Clear (2), or Exit (3).");
      // adapted from project 1 again.

      String ans = sc.nextLine().trim();
      boolean accepted = false;

      // gives options calculate, clear, or exit.
      while (!accepted) {
        if (ans.equalsIgnoreCase("calculate") || ans.equals("1")) {
          accepted = true;
          // no other action required; already added to lists.
          System.out.println("Scores added!");
          numStudents++;

          // redundancy like the first project. ensures final calculation isnt sent back
          // up to the beginning.
          System.out.println("Exit? (y)/(n)");
          String exitAnswer = sc.nextLine();
          if (exitAnswer.equalsIgnoreCase("y")) {
            exit = true;
          }

        } else if (ans.equalsIgnoreCase("clear") || ans.equals("2")) {
          accepted = true;
          System.out.println("Clearing new scores...");

          for (ArrayList arr : classList) {
            // removes last entry, effectively removing score from list.
            arr.remove(arr.size() - 1);
          }

        } else if (ans.equalsIgnoreCase("exit") || ans.equals("3")) {
          System.out.println("Exiting...\n");

          exit = true;
          accepted = true;
        } else {
          System.out.println("Input not recognized. Please enter 1 2 or 3.");
          ans = sc.nextLine().trim();
        }
        // end of accepted
      }
    }

    // main program loops are now exited. Must show stats!

    System.out.println("\nTotal students: " + (numStudents - 1));

    //for each class, show current average, high score, and low score.
    for (int k = 0; k < classes.length; k++) {
      System.out.println("\n**" + classes[k] + " stats**");
      System.out.println("Current Average: " + getAverage(classList.get(k)));
      System.out.println("High Score: " + getHighScore(classList.get(k)));
      System.out.println("Low Score: " + getLowScore(classList.get(k)));

    }
    System.out.println("\nThank you for your inputs.");
  //end of void main
  }


  // return avg value from arraylist<double>, rounded to nearest whole number
  public static int getAverage(ArrayList<Double> arr) {
    double avg = 0;
    for (double num : arr) {
      avg += num;
    }
    avg /= arr.size();
    if (avg % 1 > 0.5) //if remainder is more than .5, round up.
      return (int) avg + 1;
    else
      return (int) avg;
  }

  //return highest score in arraylist<double>. intializes at first entry, then compares all subsequent.
  public static double getHighScore(ArrayList<Double> arr) {
    double high = arr.get(0);

    for (double num : arr) {
      if (num>high) high=num;
    }
    return high;
  }

  //return lowest score in arraylist<double>. intializes at first entry, then compares all subsequent.
  public static double getLowScore(ArrayList<Double> arr) {
    double low = arr.get(0);

    for (double num : arr) {
      if (num<low) low=num;
    }
    return low;
  }

}

/*
 * test cases
 * 
 * Test 1:Enter 5students scoresas follows:
 
 1! Programming: 90, Art: 75.5, Science: 80.9, Math: 89, History: 81
 
2!  Programming: 80, Art: 60.5, Science: 81.2, Math: 93,History: 91
 3! Programming: 85, Art: 85.5, Science: 80.3, Math: 67,History: 75
 4! Programming: 90, Art: 82, Science: 80.2, Math: 89,History: 62
 5! Programming: 85, Art: 99, Science: 86.3, Math: 88,History: 66
 
 Test 2: Enter a negative
 * quantity for any class and have an error generated while not losingthe
 * running total
 
 Test 3: Add 2 more students scores:
 Programming: 85, Art: 99, Science: 86.3, Math: 88,History: 66(But hit clear so this students score is
 * cleared and not included)
 
 Programming: 99, Art: 60, Science: 79, Math: 81,History: 99
 
 Final output should show the stats for 6 Students
 * 
 */
