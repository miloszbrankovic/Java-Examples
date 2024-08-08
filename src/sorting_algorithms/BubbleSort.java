package sorting_algorithms;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] example1 = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5, 6, 5, 7, 4, 8, 3, 9, 2, 10,1};
        System.out.println("Before sorting: ");
        printArray(example1);
        System.out.println("\nAfter sorting: ");
        bubbleSort(example1);
        printArray(example1);
    }

    /**
     * This method is not very effective for large sets of data.
     *  for 1 000 000 elements execution time was 20 minutes
     *  for 1 000 00  elements execution time was 9 seconds
     *  for 1 000 0   elements execution time was 0 seconds
     * Complexity of O(n^2)
     * @param array
     */
    private static void bubbleSort(int[] array){
        boolean swapeed = true;

        while (swapeed) {
            swapeed = false;
            //We copare values in the loop to the secon to last element because we will comparing it with the one after it
            //which will be the last element so there is no reason to look at the last element by itself there is nothing after it to copare it
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapeed = true;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
