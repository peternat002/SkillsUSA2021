/* NP EAHS - PROJECT 2
not done. snapshot 10:51am.
Program #2 Project:
Grade Program Project 

Goal:You will write a program to create a screen which will allow for the entry of grades for 5 different classes. Each class will keep track of the grades with an average grade to be shown when selected. Output will also include high score and low score for each class. Number of students included in the calculation.


Requirements: 
▪Scoresof .5 ormore will be rounded up to the next whole number for the average score. Example a score of 89.5 will be 90 on the final average. 
▪Valid score range is from 0 to 100.
▪Classes: Programming, Art, Science, Math, and History. 
Screen Output will include: Class Name: # Scores Entered:Current Average:High Score:Low Score:Buttons or choices will include: Calculate(This will add the entered values into the summary)Clear(This will clear the current input, and notinclude it in calculation)Exit All screens will be clearly labeled with contestant number, program number and title. Allboxes will be clearly labeled.



*/


import java.util.ArrayList;
import java.util.Scanner;

class Proj2 {
  public static void main(String[] args) {
    System.out.println("\n--//Project 2- Grade Program- Natalie Petersen//--");

    ArrayList<Double> progList = new ArrayList<Double>();
    ArrayList<Double> artList = new ArrayList<Double>();
    ArrayList<Double> sciList = new ArrayList<Double>();
    ArrayList<Double> mathList = new ArrayList<Double>();
    ArrayList<Double> histList = new ArrayList<Double>();

    ArrayList<ArrayList> classList = {progList, artList, sciList, mathList, histList};

    String[] classes = {"Programming", "Art", "Science", "Math", "History"};
    Scanner sc = new Scanner(System.in); //for user inputs in console


    int numStudents =1;
    boolean exit=false;
    System.out.println("Please enter your scores for the following five classes.");

    while (!exit){








    }


    
  }
}
