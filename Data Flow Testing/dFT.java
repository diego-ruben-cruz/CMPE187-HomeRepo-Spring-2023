// package cmpe187dft;

import java.util.*;

public class dFT {

    // given two sorted integer arrays A and B
    int[] a;
    int[] b;

    // constructor
    public dFT(int[] x, int[] y) {
        a = x;
        b = y;
    }

    // getter for array toString method
    public int[] getA() {
        return a;
    }

    // getter for array toString method
    public int[] getB() {
        return b;
    }

    public void sortArrays() {
        quickSort(a, 0, a.length - 1);
        quickSort(b, 0, b.length - 1);
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
    public int[] merge() {
        // sortArrays(); // added additional sorting utility to allow for input of
        // unsorted arrays
        int size = a.length + b.length;

        int[] c = new int[size];

        int j = 0;
        int k = 0;

        // MergeSort loop for combining both arrays while sorting them
        for (int i = 0; i < size; i++) {
            if (j < a.length && a[j] <= b[k]) {
                c[i] = a[j];
                j++;
            } else if (j < a.length && k < b.length) {
                c[i] = b[k];
                k++;
            } else if (j == a.length && k < b.length) {
                c[i] = b[k];
                k++;
            } else {
                c[i] = a[j];
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

        dFT dFTTest = new dFT(arrayX, arrayY);
        System.out.println("Elements in array x: " + Arrays.toString(dFTTest.getA()));
        System.out.println("Elements in array y: " + Arrays.toString(dFTTest.getB()));
        System.out.println("Elements in combined array z: " + Arrays.toString(dFTTest.merge()));

        // // Testing of quickSort
        // int[] arrayA = new int[] { 11, 7, 2, 1 };
        // int[] arrayB = new int[] { 29, 16, 13, 7, 3 };

        // dFT quickSortTest = new dFT(arrayA, arrayB);
        // System.out.println("\nElements in array a BEFORE running quicksort: " +
        // Arrays.toString(quickSortTest.getA()));
        // System.out.println(
        // "Elements in array b BEFORE running quicksort: " +
        // Arrays.toString(quickSortTest.getB()) + "\n");
        // quickSortTest.sortArrays();
        // System.out.println("Elements in array a after running quicksort: " +
        // Arrays.toString(quickSortTest.getA()));
        // System.out.println("Elements in array b after running quicksort: " +
        // Arrays.toString(quickSortTest.getB()));

    }
}
