        // Testing of quickSort
        int[] arrayA = new int[] { 11, 7, 2, 1 };
        int[] arrayB = new int[] { 29, 16, 13, 7, 3 };

        dFT quickSortTest = new dFT(arrayA, arrayB);
        System.out.println("\nElements in array a BEFORE running quicksort: " +
        Arrays.toString(quickSortTest.getA()));
        System.out.println(
        "Elements in array b BEFORE running quicksort: " +
        Arrays.toString(quickSortTest.getB()) + "\n");
        quickSortTest.sortArrays();
        System.out.println("Elements in array a after running quicksort: " +
        Arrays.toString(quickSortTest.getA()));
        System.out.println("Elements in array b after running quicksort: " +
        Arrays.toString(quickSortTest.getB()));
