/* NP EAHS
* Project:
* Food Program Project 
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.println("\n--//Project 1- Food Program- Natalie Petersen//--");
    System.out.println("Welcome to my food truck!\n");

    //establish quit boolean and array of items. prices are determined by method getPrice(). 
    boolean exit = false;
    String[] menu = {"hot dog", "brat", "hamburger", "frie", "soda", "water"};
    double totalSales = 0; //calculates total price throughout all calculated orders.
    int orderNum= 1;  //order number displays.
    String allOrders = "Order List: \n"; //for display at the end. lists total quantities and all orders with \n separating each new one.

    //scanner for inputs in console
    Scanner sc = new Scanner(System.in);

    //orders run until specifically exited. prints order number and asks how many of each in the order. when all entries have been given, allows calculate, clear, or exit.    
    while (!exit){
      System.out.println("Order #"+orderNum+":");
      String orderList=("Order #" + orderNum + ": ");
      //double array is new each time. this prevents orders from carrying over.
      double[] inventory = new double[6];

       //loop to ask quantity repeats for each item in the menu. first asks how many items. then converts str answer to integer. multiplies number asked for by menu item price thru getPrice(). 
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
          //counts number of bad characters found. also catches decimals because "." is searched for and negatives  because "-" is searched for.
          for (int i=0; i<badCharacters.length(); i++){
            if (answer.contains(badCharacters.substring(i, i+1))){
              countBad++;
            }
          }
          if (countBad>0){
            if (answer.contains("-")) System.out.print("Input must not be negative.");
            else System.out.print("Input must not contain letters or other non-integer characters.");
            System.out.print(" Please try again.\n");
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
        
        //calculate total of order (by item), adding it to the inventory at location j for each item.
        inventory[j] = getPrice(j, Integer.parseInt(answer.trim()));
        orderList += Integer.parseInt(answer.trim()) + " " + item + "s ";
        
        //end of item:menu. 
        }
          
          //after all items gotten, allow calculate clear or exit.

            System.out.println("\nOptions to continue: Calculate (or press 1), Clear (2), or Exit (3).");
            String ans = sc.nextLine().trim();
            boolean accepted=false;

            while (!accepted){
        
          if (ans.equalsIgnoreCase("calculate")||ans.equals("1")){
            accepted=true;
            System.out.println("Order #" + orderNum + " received.\n");

            //add all of the order to total sales, print price of order as well.
            double totalPrice =0;
            for (double num:inventory){
              totalPrice+=num;
            }
            System.out.println("Order #" + orderNum + " total: $" + totalPrice);
            totalSales+=totalPrice;
            System.out.println("Thank you for your purchase!\n");

            allOrders += orderList + "\n";

            orderNum++;
          }
          else if (ans.equalsIgnoreCase("clear")||ans.equals("2")){
            System.out.println("Order #" + orderNum + " cleared. Resetting... \n");
            accepted=true;
            //resets automatically, as inventory is instantiated at the start of each loop.
          }
          else if (ans.equalsIgnoreCase("exit") || ans.equals("3")){
            System.out.println("Exiting...");

            exit=true;
            accepted=true;
          }
          else{
            System.out.println("Input not recognized. Please enter 1 2 or 3.");
            ans = sc.nextLine().trim();
          }
         }
          } 

         System.out.println("\nTotal orders today: " + orderNum);
         System.out.println(allOrders);
         System.out.println("Total revenue: $" + totalSales);
         System.out.println("Thank you for visiting my nondescript food truck!");

        //end main
        }
        
      //returns quantity multiplied by item price.
      public static double getPrice(int item, int quant){
      if (item==0) return quant*2.50; //hotdog 2.50
      else if (item==1) return quant*3.50; //brat 3.50
      else if (item==2) return quant*5.00; //hamburger 5.00
      else if (item==3) return quant*2.00; //fries 2.00
      else if (item==4) return quant*2.00; //soda 2.00
      else if (item==5) return 0.0; //water free
      else return 0; //should never reach
      }

  //end of Main.java
}

/* test cases 
Test 1:Enter 6 orders with Quantity 1 of each item. (calculate)
Test 2: Enter a negative quantity or other invalid field inputso that an error is generated to the user
Test3: Enter 4 more orders with Quantity 2 of all items, except for water where there are 4 waters.(calculate)
Test 4: Enter invalid characters or letters into a field and show that it is handled.
Test 5: Verify output displays all 10 orders for the day
*/
