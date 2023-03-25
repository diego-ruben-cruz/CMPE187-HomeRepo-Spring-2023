package cmpe187dft;

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
/** 
    // overloaded merge function for sort method, NOT for combining sorted array
    public int[] merge(int[] arr, int start, int mid, int end) {

        int size1 = mid - start;
        int size2 = end - mid;

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[start + i];
        }

        for (int j = 0; j < size2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;

        for (int k = 0; k < end; k++) {
            if (i < size1 && arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else if (i < size1 && j < size2) {
                arr[k] = arr2[j];
                j++;
            } else if (i == size1 && j < size2) {
                arr[k] = arr2[j];
                j++;
            } else {
                arr[k] = arr1[i];
                i++;
            }
        }
        return arr;
    }

    // in case not sorted, complementary function to sort input array. Start = 0 and end = arr.length - 1
    public int[] sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
            return arr;
        }
    }
    */

    // merge two arrays, assumes they are already sorted. Returns combined array
    public int[] merge() {

        int size = a.length + b.length;

        int[] c = new int[size];

        int j = 0;
        int k = 0;

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

        System.out.println("Elements in array a: " + Arrays.toString(dFTTest.getA()));
        System.out.println("Elements in array b: " + Arrays.toString(dFTTest.getB()));

        System.out.println("Elements in combined array c: " + Arrays.toString(dFTTest.merge()));
        
        // System.out.println(Arrays.toString(merge(arrayZ, 0, arrayZ.length - 1)));
    }
}
