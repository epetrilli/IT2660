import java.util.Scanner;
public class Listing {
    public static class Listing1 {
        public static int age1;
        public static String name1;
        public static int getAge1() // Returns the age of the listing to the client code
        {
            return age1;
        }
        public static String getName1() // Returns the age of the listing to the client code
        {
            return name1;
        }
        public static void setName1 (String n) // Stores the name for the listing in the object for that listiing
        {
            name1 = "";
        }
        public static void setAge1 (String a) // Stores the weight for the listing in the object for that listiing
        {
            Integer.toString(age1);
            age1 = 0;
        }
        public static String toString1() // Returns the age and name for this listing
        {
            return("this person's age is " + age1 +
                    "\nand their name is: " + name1);
        }
        Listing[] listings = new Listing[3];// String array of size 3 to store the age and name for this listing
    }
    public static class Listing2
    {
        public static int age2;
        public static String name2;
        public static int getAge2()
        {
            return age2;
        }
        public static String getName2()
        {
            return name2;
        }
        public static void setName2 (String n)
        {
            name2 = "";
        }
        public static void setAge2 (String a)
        {
            Integer.toString(age2);
            age2 = 0;
        }
        public String toString2()
        {
            return("this person's age is " + age2 +
                    "\nand their name is: " + name2);
        }
        Listing[] listings2 = new Listing[3];
    }
    public static class Listing3
    {
        public int age3;
        public static String name3;
        public int getAge3()
        {
            return age3;
        }
        String getName3()
        {
            return name3;
        }
        public void setName3 (String n)
        {
            name3 = "";
        }
        public void setAge3 (String a)
        {
            Integer.toString(age3);
            age3 = 0;
        }
        public String toString3()
        {
            return("this person's age is " + age3 +
                    "\nand their name is: " + name3);
        }
        Listing[] listings = new Listing[3];
    }

    public static void input()
    {

        Scanner in = new Scanner(System.in);
        int[] age = new int[3]; // Int array of size 3 to store ages for the three listings
        String[] name = new String[3]; // String array of size three to store ages for the three listings
        for(int i = 0; i < 3; i++) // Loops through each listing and prompts the user to enter the age for that listing
        {
            System.out.println("enter age for listing " + (i+1) + ": ");
            age[i] = in.nextInt();
        }
        for(int j = 0; j < 3; j++) /*Loops through each element in the array of listings and prompts the user to enter
        the name for that listing */
        {
            System.out.println("enter name for listing " + (j+1) + ": ");
            name[j] = in.next();
        }
        System.out.print("the ages for your three listings are: "); /* Loops through each element in the array of
        listings and prompts the user to enter the age for that listing in reverse order */
        for(int i = 2; i >= 0; i--)
        {
            System.out.print(age[i] + " ");
        }
        System.out.println();
        System.out.print("the names for your three listings are: "); /* Loops through the array of names and outputs
        each name that the user entered in reverse order */
        for(int j = 2; j >= 0; j--)
        {
            System.out.print(name[j] + " ");
        }


    }
    public static void main(String[] args)
    {
        input();
    }// Driver class that runs the program
}

