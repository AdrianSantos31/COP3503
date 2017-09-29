/* This program will process an array. This class contains a lot arrays

      Name: Adrian Santos
      N Number: N00798593

      Codes:
      N - Integer
      B - Boolean
      Display - Display Diag

*/

//Library Imports
import java.util.Scanner;
import java.util.Arrays;
import java.text.*;


//Main
public class Homework3
{


   public static void main (String[] args)
   {
   Scanner input = new Scanner(System.in);
   Strict run = new Strict();
   DecimalFormat formatter = new DecimalFormat ("#0.00");



   //Input
   int [][] m1 = new int[3][3];
   int [][] m2 = new int[3][3];

   System.out.print("Enter 9 numbers for List 1 / Enter 9 numbers for List 2\n");

   for (int arr1 = 0; arr1 < m1.length; arr1++)
      {
         for (int arr2 = 0; arr2 < m1[arr1].length; arr2++)
         {
            m1[arr1][arr2] = input.nextInt();
         }
      }

   for (int arr1 = 0; arr1< m2.length; arr1++)
      {
         for (int arr2 = 0; arr2<m2[arr1].length; arr2++)
         {
            m2[arr1][arr2] = input.nextInt();
         }
      }

   //The arrays are strictly equal
   System.out.print("\n");
   System.out.print("The arrays are strictly equal: " + run.equals(m1,m2));

   //How many cell values are identical in two arrays
   System.out.print("\n\n");
   System.out.print("Number of cell values that are identical in both arrays: " + run.howmany(m1,m2));


   //Returns how many cell values are identical along the diagonal
   System.out.print("\n\n");
   System.out.print("Number of cell values that are identical along the diagonal of the array: " + run.diagonal(m1,m2));




   //Average of all the cell values from  the arrays
   System.out.print("\n\n");
   System.out.print("The average of all values of the array: " + (formatter.format(run.average(m1,m2))));




   //Displays only those values of the arrays that are odd in rectangular form (row by row for each array).
   System.out.print("\n\n");
   System.out.print("Display odd values in a rectangular form \n\n");
   run.display(m1,m2);



   //returns true if the two arrays have all numbers satisfying 1 < numbers <=10  and returns  false  otherwise.
   System.out.print("\n\n");
   System.out.print("The arrays contain values 1 < numbers <=10: " + run.silly(m1,m2));
   }
}




class Strict
{
//1.) The arrays are strictly equal
   public static boolean equals(int [][]m1, int [][]m2)
   {
        boolean isitEqual = true;
        for (int i = 0; i < m1.length; i++)
        {
            for (int j = 0; j < m1.length; j++)
            {

                if (m1[i][j] != m2[i][j])
                {
                  return false;
                }

            }
        }
        return isitEqual;

   }




//2.) How many cell values are identical in two arrays
   public static int  howmany(int[][] m1, int[][] m2)
   {
       int blah = 0;
       for (int i = 0; i < m1.length; i++)
        {
               for (int j = 0; j < m1.length; j++)
               {
                  if(m1[i][j] == m2 [i][j])
                  {
                     blah ++;
                  }
               }
        }
        return blah;
     }



//3.) Returns how many cell values are identical along the diagonal
   public static int diagonal(int[][] m1, int[][] m2)
   {
       int blah = 0;
       for (int i = 0; i < m1.length; i++)
            {
               for (int j = 0; j < m1.length; j++)
               {
                  if(i==j)
                     {
                        if(m1[i][j] == m2[i][j])

                        blah++;

                     }
                     //Statements (m1[i][j] = m2[i][j])
               }
            }

          return blah;

      }


//4.) Average of all the cell values from  the arrays
   public static double  average(int[][] m1,int[][] m2)
   {

    double sum1 = 0.00;
    double sum2 = 0.00;
    double average = 0.00;

       for (int i = 0; i < m1.length; i++)
               {
                  for (int j = 0; j < m1.length; j++)
                  {
                     sum1 += m1[i][j];
                     //Statements (m1=[i][j] = m2[i][j])
                  }
               }

       for (int i = 0; i < m2.length; i++)
               {
                  for (int j = 0; j < m2.length; j++)
                  {
                     sum2 += m2[i][j];
                  }
               }
       double total = sum1+sum2;
       average=total/18.00;
       return average;
   }



//5.) Displays only those values of the arrays that are odd in rectangular form (row by row for each array).
   public static void display(int[][] m1, int[][] m2)
   {
    for (int i = 0; i < m1.length; i++)
            {
               for (int j = 0; j < m1.length; j++)
               {
                  if ((m1[i][j]%2) ==1)
                     {
                        if ((m1[i][j]/10 ==0))
                        {
                           System.out.print("    " + m1 [i][j]+"   ");
                        }
                        else
                        {
                           System.out.print((m1[i][j]+"       "));
                        }
                      }
                   else
                      {
                        System.out.print("      ");
                      }

                  System.out.print(" ");
                  //Statements (m1=[i][j] = m2[i][j])
               }


               System.out.println();

            }
               System.out.print("\n");
            for (int k = 0; k < m1.length; k++)
            {
               for (int l = 0; l < m1.length; l++)
               {
                  if ((m2[k][l]%2) ==1)
                     {
                        if ((m2[k][l]/10 ==0))
                        {
                           System.out.print("    " + m2 [k][l]+"   ");
                        }
                        else
                        {
                           System.out.print((m2[k][l]+"       "));
                        }
                      }
                   else
                      {
                        System.out.print("      ");
                      }

                  System.out.print(" ");
                  //Statements (m1=[i][j] = m2[i][j])
               }


               System.out.println();

            }
    }





//6.) returns true if the two arrays have all numbers satisfying 1 < numbers <=10  and returns  false  otherwise.
   public static boolean silly(int[][] m1, int[][] m2)
   {
    for (int i = 0; i < m1.length; i++)
            {
               for (int j = 0; j < m1.length; j++)
               {
                    if(!(m1[i][j]>1 && m1[i][j]<=10 && m2[i][j]>1 && m2[i][j]<=10))
                     {
                       return false;

                     }
                 // Statements (m1=[i][j] = m2[i][j])
               }
            }
     return true;
   }
}
