/* This program combines problems 5.24 and 5.25
   5.24 - Sum a series
   5.25 - Compute pI (π)
   
   Written by: Adrian Santos (N00798593)
   Date: 09/07/2016
*/
import java.util.Scanner;
import java.io.*;//The following imports were suggested by Riya (tutor)
import java.util.*;
import java.lang.*;
import java.text.*;

public class n00798593
{
   public static void main(String [] args)
   {
      //Creates a scanner type
      Scanner input = new Scanner(System.in);
      
      //Variable Initialization
      double loop_answer_1 = 0;
      double loop_answer_2 = 0;
  
      //Decimal Formatter
      DecimalFormat formatter = new DecimalFormat ("#0.000000000000");
      
      //Gets input from the user
      System.out.print("Please enter a single odd positive integer: ");
      int number_1 = input.nextInt();
      
      //Number should be subtracted by 2 for easier loops
      int number_2 = number_1 - 2;
      
      //For Loop for Problem 5.24
      for (int loop_1 = 1; loop_1 <= number_2; loop_1+=2)
         {
         loop_answer_1 += (loop_1) / (loop_1 + 2.0);
         }

         
         //Output
         System.out.print("The sum of the fractions is: " + (formatter.format(loop_answer_1)) + "\n");
         
      //For Loop for Problem 5.25
     for (int loop_2 = 1; loop_2 <=number_1; loop_2++)
         {
               loop_answer_2 += (4*(Math.pow(-1,loop_2+1)))/((2*loop_2)-1);
               //System.out.print(loop_2 + " ");
         }
       
         //Output
         System.out.print("The value of pi is: " + (formatter.format(loop_answer_2)));



   }
}   