/* This program is a requirement for Homework 4. This will show proficiency from Chapters 1-12
Student Name: Adrian Santos
N Number: N00798593
Date Created: October 8, 2016


Your code must override the toString method in each class to display ALL the relevant information from the record.
Also design an application class (your nnumber class with a main)  that tests your classes and processes a file of records.

The file of data to be used will be constructed by me with the following format used (examples are here):
I WILL USE NOTEPAD TO CONSTRUCT THE FILE. TEST WITH A FILE FROM NOTEPAD.

vehicle
owner's name (string)
address (string)
phone (string)
email (string)

car
owner's name (string)
address (string)
phone (string)
email (string)
true or false for convertible (boolean)
color (string)

american car
owner's name (string)
address (string)
phone (string)
email (string)
true or false for convertible (boolean)
color (string)
true or false for made in Detroit (boolean)
true or false for union shop (boolean)

foreign car
owner's name (string)
address (string)
phone (string)
email  (string)
true or false for convertible (boolean)
color (string)
country of manufacturer (string)
import duty (float)

bicycle
owner's name (string)
address (string)
phone (string)
email (string)
# of speeds (int)

truck
owner's name (string)
address (string)
phone (string)
email (string)
# of tons (float)
cost of truck (float)
date purchased (format below in exmample)


etc.....these records can appear in any order and there can be up to 200 of them.

Records will have a blank line between them.

You will need to use an array of vehicle to store the data.

Here are some examples of data:


foreign car
aMarioy
Mario's house
(777) 777-7777
gmario@mario.com
false
black
Italy
4415.91

truck
aDougy
Doug's house
(123) 456-7890
hdoug@doug.com
30
61234.56
8/10/2003

vehicle
aRobby
Rob's house
(987) 654-3210
irob@rob.com

bicycle
bTommy
Tom's house
(246) 810-1214
jtom@tom.com
7

truck
bGeorge
George's house
(666) 666-6666
kgeorge@george.com
25
51234.56
12/4/2004

vehicle
bTim
Tim's house
(111) 111-1111
tim@tim.com

bicycle
bJim
Jim's house
(555) 555-5555
Ajim@jim.com
5

american car
bJohn
John's house
(888) 888-8888
Bjohn@john.com
true
green
false
true

car
cKen
Ken's house
(999) 999-9999
Cken@ken.com
false
orange

foreign car
cMario
Mario's house
(777) 777-7777
Dmario@mario.com
false
black
Italy
4415.91

truck
zDoug
Doug's house
(123) 456-7890
Edoug@doug.com
30
61234.56
8/10/2003

vehicle
eRob
Rob's house
(987) 654-3210
Frob@rob.com

bicycle
fTom
Tom's house
(246) 810-1214
Gtom@tom.com
7

american car
gSam
Sam's house
(333) 333-3333
Hsam@sam.com
false
blue
true
false



Write an application class (your nnumber with a main) that reads a file (from the command line) and fills an array of type vehicle[] with new vehicle
(params), new car (params), new american car (params) new foreign car(params) , new truck (params),
new bicycle (params), etc.: the params depend on the first line that identifies each record. params is just a shorthand name for parameter list (the arguments
to a method.)

To get the file , in jGrasp you must click on the tab file/check run args, and then type the name of the file in the box at the top.
I will test your program with my own file! You must not type in the name of the file in your code because it is only specified at run time.
The name of the file in your code will be args[0] when you use public static void main(String[], args) throws FileNotFoundException .
Because the input comes from the file instead of the keyboard you should be able to modify Scanner to deal with wrapping!
Scanner x = new Scanner(new File(args[0])). Google "java scanner" to learn about Scanner and/or "java command line" to learn about args[0].
This information is located on pages 478-480 of Liang's 10th Edition.

Print the output from each of the following calls:

1.  Call a printAll method that can be passed an array of type vehicle[] and which prints each element of
the array using the appropriate toString() methods. ArrayList is fine if you wish to use it.

2.  Call a sort method that can be passed an array of type vehicle[] and which sorts the array by email addresses
and prints the new sorted array using appropriate toString() methods. Any sort method is fine, but it should
sort according to unicode (case sensitive, that is to say that all upper case is before any lower case)!

3.  Call a method that prints the number of records.

4.  Call a method that prints just the bicycles and trucks (from the sorted array using the appropriate toString() methods).

5.  Call a method that prints the vehicles in area code 987.

THERE ARE NO PROMPTS. JUST RUN THE PROGRAM.

**************************************End of Instruction*****************************************************************************
*/

//Library Imports
import java.util.Scanner; //for File Input
import java.io.FileNotFoundException; //If .txt file is not there, print return as null
import java.util.ArrayList;//For method
import java.util.Arrays;//for Sort method
import java.io.File;



public class n00798593 {


   public static void main(String[] args) throws FileNotFoundException{

   //Scanner
      File file = new File (args[0]);
      Scanner input = new Scanner (file);

   //Array of Vehicles
      ArrayList<Vehicle> arrayOfVehicles = new ArrayList<>();

      while (input.hasNextLine()){
       String line = input.nextLine();

      //Tests if the line is
         if(line.equals("vehicle")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();

            arrayOfVehicles.add(new Vehicle(name, address, phone, email));
         }

         else if(line.equals("car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();

            arrayOfVehicles.add(new Car(name, address, phone, email, convertible, color));
         }

         else if(line.equals("american car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();
            boolean detroit = input.nextBoolean();
            boolean unionshop = input.nextBoolean();
            input.nextLine();


            arrayOfVehicles.add(new AmericanCar(name, address, phone, email, convertible, color, detroit, unionshop));

         }

         else if(line.equals("foreign car")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            boolean convertible = input.nextBoolean();
            input.nextLine();
            String color = input.nextLine();
            String country = input.nextLine();
            float importduty = input.nextFloat();
            input.nextLine();

            arrayOfVehicles.add(new ForeignCar(name, address, phone, email, convertible, color, country, importduty));

         }

         else if(line.equals("bicycle")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            int speeds = input.nextInt();
            input.nextLine();

            arrayOfVehicles.add(new Bicycle(name, address, phone, email, speeds));

         }

         else if(line.equals("truck")){
            String name = input.nextLine();
            String address = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            float tons = input.nextFloat();
            float costoftruck = input.nextFloat();
            input.nextLine();
            String datepurchased = input.nextLine();

            arrayOfVehicles.add(new Truck(name, address, phone, email, tons, costoftruck, datepurchased));
         }

         } //End Input Check

      input.close();//Closes the file

   /* Syntax
   Printmethod
   method(Blah)
   */


   //Methods
/*
   //Print all
      System.out.print("This prints all records");
      System.out.print("\n");
      printAll(arrayOfVehicles);

   //Sorted Array by Vehicles and Arrays
      System.out.print("This sorts the Vehicles by email");
      System.out.print("\n");
      sortedArray(arrayOfVehicles);

   //Prints the number of records
      System.out.print("The number of records are: ");
      System.out.print("\n");
      printRecords(arrayOfVehicles);

   //Prints the bicycle and truck records only
      System.out.print("The bicycle and trucks are: ");
      System.out.print("\n");
      bikeAndTrucks(arrayOfVehicles);

   //Prints the records
      System.out.print("This displays the records with the (987) area code: ");
      System.out.print("\n");
      areaCode(arrayOfVehicles);

   /*
   1. Call a printAll method that can be passed an array of type vehicle[] and which prints each element of
    the array using the appropriate toString() methods. ArrayList is fine if you wish to use it.
    -----------------------------------------------------------------------------------------------------------------
    (1) Call a method that passes vehicle[]
    (2) Print each element of vehicle[] with toString(). Can use ArrayList

   	public static void printAll(ArrayList<Vehicle> array){
      for(int i = 0; i<= array.size() - 1; i++){
        System.out.print(arrayOfVehicles.get(i).toString());
        System.out.print(" ");
      }
   	}



   /*
   2. Call a sort method that can be passed an array of type vehicle[] and which sorts the array by email addresses
   and prints the new sorted array using appropriate toString() methods. Any sort method is fine, but it should
   sort according to unicode (case sensitive, that is to say that all upper case is before any lower case)!
   -----------------------------------------------------------------------------------------------------------------
   (1) Do a sort method by vehicles []
   (2) Do a sort method by email address
   (3) print the new sorted array using toString()

    public static void sortedArray(ArrayList<Vehicle> array){


    }

   */

   /*
   3.  Call a method that prints the number of records.
    -----------------------------------------------------------------------------------------------------------------
   (1) Print all Vehicles

    public static void printRecords(ArrayList<Vehicle> array){


    }


   */


   /*
   4.  Call a method that prints just the bicycles and trucks (from the sorted array using the appropriate toString() methods).
    -----------------------------------------------------------------------------------------------------------------
    (1) Search bicycles and trucks only from NUMBER 2
    (2) Print bicycle and trucks

   	public static void bikeAndTrucks(ArrayList<Vehicle> array){


   	}

   */

   /*
   5.  Call a method that prints the vehicles in area code 987.
    -----------------------------------------------------------------------------------------------------------------
    (1) Search if area code is (987)
    (2) Print the vehicles with area code (987)

   	public static void areaCode(ArrayList<Vehicle> array){


   	}
   */

   }

   static class Vehicle{//Superclass & Supposed to be an array
   	/*vehicle
   	owner's name (string)					         *****1*****
   	address (string)						            *****2*****
   	phone (string)							            *****3*****
   	email (string)							            *****4*****
   	*/

      private String ownername;
      private String address;
      private String phone;
      private String email;

   	//null
      public Vehicle(){

      }

   	//Constructor with Strings of the name
      public Vehicle (String ownername, String address, String phone, String email){
         this.ownername = ownername;
         this.address = address;
         this.phone = phone;
         this.email = email;
      }

   	//Set and Get ownername
      public String getOwnername(){
         return ownername;
      }

      public void setOwnername(String newOwnername){
         this.ownername = newOwnername;
      }

   	//Set and Get address
      public String getAddress(){
         return address;
      }

      public void setAddress(String newAddress){
         this.address = newAddress;
      }

   	//Set and Get phone
      public String getPhone(){
         return phone;
      }

      public void setPhone (String newPhone){
         this.phone = newPhone;
      }

   	//Set and Get email
      public String getEmail(){
         return email;
      }

      public void setEmail(String newEmail){
         this.email = newEmail;
      }

      public boolean equals (Object obj){
         return true;
      }

      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
             + 	 "Address: "+ getAddress()  + "\n"
             +   "Phone Number: "+ getPhone()   + "\n"
             +   "Email: "+ getEmail()  + "\n";

      }

   } //Vehicle class

   static class Car extends Vehicle{
   	/*car
   	1,2,3,4
   	true or false for convertible (boolean) 		*****5***** NEW
   	color (string) 									   *****6*****	NEW
   	*/
      private boolean convertible;
      private String color;

      public Car(){


      }
      public Car (String ownername, String address, String phone, String email,
      						boolean convertible, String color){
         setOwnername(ownername);
         setAddress(address);
         setPhone(phone);
         setEmail(email);
         this.convertible = convertible;
         this.color = color;
      }

      public boolean getConvertible(){
         return convertible;
      }

      public void setConvertible(boolean newConvertible){
         this.convertible = newConvertible;
      }

      public String getColor (){
         return color;
      }

      public void setColor(String newColor){
         this.color = newColor;
      }

      public boolean equals (Object obj){
         return true;

      }

      @Override
      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
            	+	 "Address: "+ getAddress()  + "\n"
            	+  "Phone Number: "+ getPhone()   + "\n"
            	+  "Email: "+ getEmail()  + "\n"
            	+	 "Convertible: "+ getConvertible()  + "\n"
            	+  "Color: "+ getColor() + "\n";

      }


   }

   static class AmericanCar extends Car{
   	/*american car
   	1,2,3,4,5,6
   	true or false for made in Detroit (boolean)	*****7*****
   	true or false for union shop (boolean)			*****8*****
   	*/

      private boolean detroit;
      private boolean unionshop;

      public AmericanCar(){

      }

      public AmericanCar(String ownername, String address, String phone, String email, boolean convertible, String color, boolean detroit, boolean unionshop){
         setOwnername(ownername);
         setAddress(address);
         setPhone(phone);
         setEmail(email);
         setConvertible(convertible);
         setColor(color);
         this.detroit = detroit;
         this.unionshop = unionshop;


      }

      public boolean getDetroit(){
         return detroit;
      }

      public void setDetroit(boolean newDetroit){
         this.detroit = newDetroit;
      }

      public boolean getUnionshop(){
         return unionshop;
      }

      public void setUnionshop(boolean newUnionshop){
         this.unionshop = newUnionshop;
      }

      public boolean equals (Object obj){
         return true;

      }

      @Override
      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
            	+  "Address: "+ getAddress()  + "\n"
            	+  "Phone Number: "+ getPhone()   + "\n"
            	+  "Email: "+ getEmail()  + "\n"
            	+	 "Convertible: "+ getConvertible()  + "\n"
            	+  "Color: "+ getColor() + "\n"
            	+  "Made in Detroit: "+ getDetroit()  + "\n"
            	+	 "Made in a Union Shop: "+ getUnionshop()  + "\n";

      }


   }

   static class ForeignCar extends Car{
   	/*american car
   	1,2,3,4,5,6
   	country of manufacturer (string)				   *****9*****
   	import duty (float)								   *****10*****
   	*/
      private String country;
      private float importduty;

      public ForeignCar(){

      }

      public ForeignCar(String ownername, String address, String phone,String email,
      									boolean convertible, String color, String country, float importduty){
         setOwnername(ownername);
         setAddress(address);
         setPhone(phone);
         setEmail(email);
         setConvertible(convertible);
         setColor(color);
         this.country = country;
         this.importduty = importduty;

      }

      public String getCountry(){
         return country;
      }

      public void setCountry(String newCountry){
         this.country = newCountry;
      }

      public float getImportduty(){
         return importduty;
      }

      public void setImportduty(float newImportduty){
         this.importduty = newImportduty;
      }

      public boolean equals (Object obj){
         return true;

      }

      @Override
      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
            	+  "Address: "+ getAddress()  + "\n"
            	+  "Phone Number: "+ getPhone()   + "\n"
            	+  "Email: "+ getEmail()  + "\n"
            	+	 "Convertible: "+ getConvertible()  + "\n"
            	+  "Color: "+ getColor() + "\n"
              +  "Country: "+ getCountry()  + "\n"
            	+  "Import Duty: "+ getImportduty()  + "\n";

      }
   	//Print???
   }

   static class Bicycle extends Vehicle{
   	/*bicycle
   	1,2,3,4
   	# of speeds (int)						            *****11*****
   	*/
      private int speeds;

      public Bicycle(){

      }

      public Bicycle (String ownername, String address,
      								String phone, String email, int speeds){
         setOwnername(ownername);
         setAddress(address);
         setPhone(phone);
         setEmail(email);
         this.speeds = speeds;

      }

      public int getSpeeds(){
         return speeds;
      }

      public void setSpeeds(int newSpeeds){
         this.speeds = newSpeeds;
      }

      public boolean equals (Object obj){
         return true;

      }

      @Override
      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
            	 + "Address: "+ getAddress()  + "\n"
            	 + "Phone Number: "+ getPhone()   + "\n"
            	 + "Email: "+ getEmail()  + "\n"
            	 + "Speeds: "+ getSpeeds()  + "\n";


      }

   	//Print????

   }

   static class Truck extends Vehicle{
   	/*vehicle
   	1,2,3,4
   	# of tons (float)						            *****12*****
   	cost of truck (float)					         *****13*****
   	date purchased (MM/DD/YYYY)			         *****14*****
   	*/
      private float tons;
      private float costoftruck;
      private String datepurchased; //MM/DD/YYYY

      public Truck(){

      }
      public Truck(String ownername, String address, String phone, String email,
      							float tons, float costoftruck, String datepurchased){
         setOwnername(ownername);
         setAddress(address);
         setPhone(phone);
         setEmail(email);
         this.tons = tons;
         this.costoftruck = costoftruck;
         this.datepurchased = datepurchased;


      }

      public float getTons(){
         return tons;
      }

      public void setTons(float newTons){
         this.tons = newTons;
      }

      public float getCostoftruck(){
         return costoftruck;
      }

      public void setCostoftruck(float newCostoftruck){
         this.costoftruck = newCostoftruck;
      }
      public String getDatepurchased(){
         return datepurchased;
      }

      public void setDatepurchased(String newDatepurchased){
         this.datepurchased = newDatepurchased;
      }

      public boolean equals (Object obj){
         return true;

      }

      @Override
      public String toString(){
         return "Owner's name: " + getOwnername() + "\n"
            	 + "Address: "+ getAddress()  + "\n"
            	 + "Phone Number: "+ getPhone()   + "\n"
            	 + "Email: "+ getEmail()  + "\n"
            	 + "Tons: "+ getTons() + "\n"
            	 + "Truck Cost: "+ getCostoftruck()  + "\n"
            	 + "Date Purchased: "+ getDatepurchased() + "\n";

      }
   	//Print
   }
}
