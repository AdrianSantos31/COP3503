/* This program will compute the cost of driving based on the:
   A.) Driving distance,
   B.) Fuel efficiney of the car in miles per gallon
   C.) Price per gallon
   
   Written by: Adrian Santos 
               N00798593
   Date: 08/26/2016 */

import java.util.Scanner; //This will import the scanner library

public class Homework1 //UNF N number as the file name (Class)
{
   public static void main (String [] args) //Method
   {
      Scanner input = new Scanner (System.in); // Create a Scanner
      
      //This will prompt the user to enter the driving distance
      System.out.print("Enter the driving distance: ");
      double DrivingDistance = input.nextDouble();
      
      //This will prompt the user to enter the fuel efficiency for a car
      System.out.print("Enter miles per gallon: ");
      double MilesPerGallon = input.nextDouble();
      
      //This will prompt the user to enter the fuel cost
      System.out.print("Enter price per gallon: ");
      double PricePerGallon = input.nextDouble();
      
      //This computes the cost of driving a certain car
      double CostofDriving = (DrivingDistance / MilesPerGallon) * PricePerGallon;
      
      //Prints the output. The result would print 2 decimal points
      System.out.print("The cost of driving is $" + (int) (CostofDriving * 100) / 100.0); 
   }
}