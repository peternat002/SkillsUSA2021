//LIKELY CURRENTLY BUGGY. snapshot at 9:37am.

/* NP EAHS

Project:
Food Program Project 
Goal: You will write a program to create a screen which will allow the user to enter quantities of items to purchase from your food truck. Taxes are included in the price. You must have a running total of all sales for the day sales. 

Requirements: 
Items for sale: Hot Dog $2.50, Brat $3.50, Hamburger $5.00, Fries $2.00,Soda $2.00, Water is Free

Buttons or choices will include: 
Calculate (Add this order to the register, clear to add another)
Clear (allows for another entry, but this entry is not added
Exit (Exit the program)

All screens will be clearly labeled with contestant number, program number and title.For each order the user should be allowed to enter any quantity for each item. All invalid inputs should generate an erro



*/
import java.util.Scanner;

class Proj1 {
  public static void main(String[] args) {
    System.out.println("\n--//Project 1- Food Program- Natalie Petersen//--");

    //establish quit boolean and array of items. prices will be in if statements while running.
    boolean exit = false;
    String[] menu = {"hot dog", "brat", "hamburger", "frie", "soda", "water"};
    double totalSales = 0;
  

    //scanner for inputs in console
    Scanner sc = new Scanner(System.in);


    int orderNum= 1;
    //runs until exited. prints order number and asks how many of each in the order. when all entries have been given, allows calculate, clear, exit.    
    while (!exit){
      
      System.out.println("Order #"+orderNum+":");
      double[] inventory = new double[6];

       //repeats for each item in the menu. asks how many items. converts str answer to integer. multiplies number asked for by menu item price. adds to totalSales. 
       for (int j=0; j<menu.length; j++){
        String item = menu[j];
        System.out.print("How many " + item + "s?:");

        String answer = sc.nextLine().trim();

        boolean accepted=false;
        String badCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-=_+[]\\{}|;:\"\',<.>/?~`";

        //ensures input is not empty, not letters, not decimals, not negative
        while (!accepted){
          if (answer.length() ==0){
            System.out.println("No input received. Please try again.");
          }
          else{
          int countBad=0;
          //counts number of bad characters found. also catches decimals because "." is searched for and negaitves  because "-" is searched for.
          for (int i=0; i<badCharacters.length(); i++){
            if (answer.contains(badCharacters.substring(i, i+1))){
              countBad++;
            }
          }
          if (countBad>0){
            System.out.println("Input must not contain letters or other non-integer characters, nor can input be negative. Please try again.");
             }
                else{
                  accepted=true;
                   }
          }
        
          if (!accepted){
            System.out.print("How many " + item + "s?: ");
              answer = sc.nextLine().trim();
          }
          }
        //end of accepted loop. will be an accepted int from here.

        

        }
        
        //set total at location j (item location) to the price * quantity asked for. Only if calculate is selected is this inventory used, but needs to keep track during each ask anyway.
        inventory[j] = getPrice(j, Integer.parseInt(answer.trim()));

        
      //end for item:menu loop
      /*
      Hot Dog $2.50, Brat $3.50, Hamburger $5.00, Fries $2.00,Soda $2.00, Water is Free
      */
      System.out.println("\nOptions to continue: Calculate (or press 1), Clear (2), or Exit (3).");
        String secondAns = sc.nextLine().trim();
        boolean accepted2nd=false;
        {
          if (secondAns.equalsIgnoreCase("calculate")||secondAns.equalsIgnoreCase("1")){

          }
       }

      //end exit
       }
       
        }   
       


      public static double getPrice(int item, int quantity){
      case (0){
        
      }
      return 0.0;
      }



  //end of main
}
