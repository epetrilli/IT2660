package topdownmergesort;
import java.util.*;

public class TopDownMergeSort {
    public TopDownMergeSort(int[] rnArray) {
    }
    public static void mergeSort(int rnArray[], int temp[], int leftIndex, int rightIndex)
    {
        int midIndex, nRnArray;
        nRnArray = rightIndex - leftIndex + 1;
        if (nRnArray == 1) // Base case
            return;
        midIndex = (rightIndex + leftIndex) / 2;
        // Reduced problems to sort the left and right halves of the array
        mergeSort(rnArray, temp, leftIndex, midIndex);
        mergeSort(rnArray, temp, midIndex + 1, rightIndex);
        // General solution to merge the reduced problems
        merge(rnArray, temp, leftIndex, midIndex + 1, rightIndex);
        return;
    }
    public static void merge(int rnArray[], int temp[], int leftIndex, int midIndex, int rightIndex)
    {
        int leftEnd, nRnArray, tempsIndex;
        leftEnd = midIndex - 1;
        tempsIndex = leftIndex;
        nRnArray = rightIndex - leftIndex + 1;
        while ((leftIndex <= leftEnd) && (midIndex <= rightIndex))
        // Move items into temp array
        {
            if (rnArray[leftIndex] <= rnArray[midIndex])
            {
                temp[tempsIndex] = rnArray[leftIndex];
                tempsIndex = tempsIndex + 1;
                leftIndex = leftIndex + 1;
            }
            else // Move item from the right half into temp array
            {
                temp[tempsIndex] = rnArray[midIndex];
                tempsIndex = tempsIndex + 1;
                midIndex = midIndex + 1;
            }
        }
        if(leftIndex <= leftEnd) {
            while (leftIndex <= leftEnd)
            // Copy remainder of left half into the temp array
            {
                temp[tempsIndex] = rnArray[leftIndex];
                leftIndex = leftIndex + 1;
                tempsIndex = tempsIndex + 1;
            }
        }
        else
        {
            while (midIndex <= rightIndex)
            // Copy remainder of right half into the temp array
            {
                temp[tempsIndex] = rnArray[midIndex];
                midIndex = midIndex + 1;
            }
        }
        for (int i = 0; i < nRnArray; i++) // Copy items back into the original array
        {
            rnArray[rightIndex] = temp[rightIndex];
            rightIndex = rightIndex - 1;
        }
    }
}

