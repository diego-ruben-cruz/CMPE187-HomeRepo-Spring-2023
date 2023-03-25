// package cmpe187dft;

import java.util.*;

public class dFT {

    static void sortArrays(int[] arrayOne, int[] arrayTwo) {
        quickSort(arrayOne, 0, arrayOne.length - 1);
        quickSort(arrayTwo, 0, arrayTwo.length - 1);
    }

    /**
     * Utility partition function for QuickSort
     * 
     * @param toBeSorted The int array to be sorted
     * @param lowerBound The lower bound for the partition
     * @param upperBound The upper bound for the partition
     * @return
     */
    static int partition(int[] toBeSorted, int lowerBound, int upperBound) {
        int pivot = toBeSorted[lowerBound];
        int m = lowerBound;

        // Checks each element in the unsorted region
        for (int k = lowerBound + 1; k <= upperBound; k++) {
            if (toBeSorted[k] < pivot) {
                m++;
                swap(toBeSorted, k, m);
            }
        }

        // swaps pivot with a[m]
        swap(toBeSorted, lowerBound, m);

        // returns the index of pivot
        return m;
    }

    // Swap operation for an integer array
    static void swap(int[] inputArray, int currentIndex, int prevIndex) {
        int temp;
        temp = inputArray[prevIndex];
        inputArray[prevIndex] = inputArray[currentIndex];
        inputArray[currentIndex] = temp;
    }

    /**
     * QuickSort implementation
     * 
     * Best Case O(n log(n))
     * Worst Case O(n^2)
     * 
     * Stable
     * 
     * @param toBeSorted
     * @param lowerBound
     * @param upperBound
     */
    static void quickSort(int[] toBeSorted, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            // Finds the pivot index with partition function
            int pivotIndex = partition(toBeSorted, lowerBound, upperBound);

            // Recursive calls to sort both portions
            quickSort(toBeSorted, lowerBound, pivotIndex - 1);
            quickSort(toBeSorted, pivotIndex + 1, upperBound);
        }
    }

    // merge two arrays, assumes they are already sorted. Returns combined array
    static int[] merge(int[] arrayOne, int[] arrayTwo) {
        // sortArrays(); // added additional sorting utility to allow for input of
        // unsorted arrays
        int size = arrayOne.length + arrayTwo.length;

        int[] c = new int[size];

        int j = 0;
        int k = 0;

        // MergeSort loop for combining both arrays while sorting them
        for (int i = 0; i < size; i++) {
            if (j < arrayOne.length && arrayOne[j] <= arrayTwo[k]) {
                c[i] = arrayOne[j];
                j++;
            } else if (j < arrayOne.length && k < arrayTwo.length) {
                c[i] = arrayTwo[k];
                k++;
            } else if (j == arrayOne.length && k < arrayTwo.length) {
                c[i] = arrayTwo[k];
                k++;
            } else {
                c[i] = arrayOne[j];
                j++;
            }
        }
        return c;
    }

    public static void main(String[] args) {

        // driver program
        int[] arrayX = new int[] { 1, 2, 7, 11 };
        int[] arrayY = new int[] { 3, 7, 13, 16, 29 };
        // int[] arrayZ = new int[] {1,5,7,3,5,7,3,5,8,9,0,3,45,56,34,6,7,30};

        System.out.println("Elements in array x: " + Arrays.toString(arrayX));
        System.out.println("Elements in array y: " + Arrays.toString(arrayY));
        System.out.println("Elements in combined array z: " + Arrays.toString(merge(arrayX, arrayY)));

        // Testing of quickSort
        int[] arrayA = new int[] { 11, 7, 2, 1 };
        int[] arrayB = new int[] { 29, 16, 13, 7, 3 };

        System.out.println("\nElements in array a BEFORE running quicksort: " +
                Arrays.toString(arrayA));
        System.out.println(
                "Elements in array b BEFORE running quicksort: " +
                        Arrays.toString(arrayB));
        sortArrays(arrayA, arrayB); // This performs quickSort on both arrays.
        System.out.println("Elements in array a AFTER running quicksort: " +
                Arrays.toString(arrayA));
        System.out.println("Elements in array b AFTER running quicksort: " +
                Arrays.toString(arrayB));

    }
}
