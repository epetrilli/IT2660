package topdownmergesort;
import java.util.*;
import java.util.Arrays;
public class RandomNumbers {
    public static void main(String[] args) {
        int i;
        Random rnd = new Random(); // Create an rnd object of the Random class
        int[] rnArray1 = new int[100]; // Create an array to store 100 random numbers
        for (i = 0; i < rnArray1.length; i++) {
            int randomNumber = rnd.nextInt(100); // Generate a random number between 1 and 100
            rnArray1[i] = i + 1;
            System.out.println("Random No:" + randomNumber);
        }
        int[] rnArray = rnArray1.clone(); // Copy the array of random numbers
        for (i = 0; i < rnArray.length; i++)
        {
            int sortedNumber = rnd.nextInt(100);
            rnArray[i] = i + 1;
        }
        new TopDownMergeSort(rnArray); // Call the MergeSort method to sort the copied array
        System.out.println("Merge sort of random numbers " + Arrays.toString(rnArray));
    }
}


