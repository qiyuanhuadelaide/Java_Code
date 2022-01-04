package main.im.qiyuanhu.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class hw9 {

    public static void main(String[] args) {

        /*
         * in the end, the code will create a csv file to store all records of the
         * elapsed time of each sorting algorithm Then import the csv file to a
         * spreadsheet so that we can have a detailed table view of the results
         */

        // Specify file name
        String outputFilename = "hw9_QH_output.csv";
        PrintWriter outputFile = null;

        // Instantiate printwriter object
        try {
            outputFile = new PrintWriter(new FileWriter(outputFilename));
        } catch (IOException ex) {
            System.exit(1);
        }

        // Create an array of string for the sorting algorithm types
        String[] sorts = new String[] { "insertion", "merge", "quick", "heapsort" };

        // Create an array for the input sizes
        int[] inputSizes = new int[] { 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000 };

        // Print Headers
        outputFile.print("n Algorithm,");
        for (int inputSize : inputSizes) {
            outputFile.print(inputSize + ",");
        }

        outputFile.println();
        outputFile.flush();

        // Create a random class object
        Random random = new Random();

        // loop through each value of input sizes in the array

        for (String sort : sorts) {

            // Print first the sort type
            outputFile.print(sort + ",");

            for (int inputSize : inputSizes) {

                int[] array = new int[inputSize];

                // generate values for the array from 1 to 1M
                for (int i = 0; i < array.length; i++) {
                    // Generate number from 1 to 1 Million
                    array[i] = random.nextInt(1000000) + 1;
                }

                long startTime = System.currentTimeMillis();

                // Then we identify the sort type
                switch (sort) {
                    case "insertion":
                        insertionSort(array);
                        break;
                    case "merge":
                        mergeSort(array, 0, array.length - 1);
                        break;
                    case "quick":
                        quickSort(array, 0, array.length - 1);
                        break;
                    case "heapsort":
                        heapSort(array);
                        break;
                }

                // Get end time
                long endTime = System.currentTimeMillis();

                // Compute for the execution time
                long elapsedTime = endTime - startTime;

                // Print the value of the execution time
                outputFile.print(elapsedTime + ",");
            }

            // Print to the next line
            outputFile.println();
            // Then finalize write to output file
            outputFile.flush();
        }
    }

    // Insertion sort
    static void insertionSort(int[] array) {
        int size = array.length;

        for (int i = 1; i < size; i++) {
            int key = array[i];
            int x = i - 1;
            while ((x > -1) && (array[x] > key)) {
                array[x + 1] = array[x];
                x--;
            }
            array[x + 1] = key;
        }
    }

    // Merge sort
    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Get the middle index
            int middle = left + (right - left) / 2;

            // Sort the left values and right values base on the middle value
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two sub arrays to be merged
        int size1 = middle - left + 1;
        int size2 = right - middle;

        // Create temp arrays
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to temp arrays
        for (int i = 0; i < size1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < size2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temp arrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left array
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of right array
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    private static void quickSort(int[] array, int start, int end) {

        int temp;

        // getting middle index
        int middle = (start + end) / 2;

        // swapping middle and end values
        temp = array[middle];
        array[middle] = array[end];
        array[end] = temp;
        middle = end;


        // looping variables
        int i = start;
        int j = end - 1;

        boolean isDoneLoop = false;

        while (!isDoneLoop) {
            while (array[i] < array[middle]) {
                i++;
            }
            while ((j >= 0) && (array[middle] < array[j])) {
                j--;
            }
            if (i < j) {

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            } else {
                isDoneLoop = true;
            }
        }

        temp = array[i];
        array[i] = array[middle];
        array[middle] = temp;
        if (start < i - 1) {
            quickSort(array, start, i - 1);
        }

        if (i + 1 < end) {
            quickSort(array, i + 1, end);
        }
    }

    // Heap Sort
    static void heapSort(int[] array) {
        int size = array.length;

        // Build heap using heapify
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);

        // Extract each element from the heap
        for (int i = size - 1; i > 0; i--) {
            // Move current to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call method heapify on the reduced heap
            heapify(array, i, 0);
        }
    }
    // End for methods of Quick Sort

    static void heapify(int[] array, int size, int i) {
        // Set root as highest
        int highest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is higher than root
        if (left < size && array[left] > array[highest])
            highest = left;

        // If right child is higher than highest so far
        if (right < size && array[right] > array[highest])
            highest = right;

        // If highest is not root
        if (highest != i) {
            int swap = array[i];
            array[i] = array[highest];
            array[highest] = swap;

            // Recursively call heapify on the affected subtree
            heapify(array, size, highest);
        }
    }
    // End of Methods for Heap Sort

}