package sorting_algorithms;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] example1 = {2, 1, 7, 4, 9, 6, 8, 3, 10, 5};
        int[] example2 = {2, 1, 7, 4, 9, 6, 8, 3, 10, 5, 1, 6};

        System.out.println("Before: ");
        printArray(example2);

        quickSort(example2);
//        quickSort(example1, 0, example1.length - 1);

        System.out.println("\nAfter: ");
        printArray(example2);

    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    //reqursive algorightm where after we do partitioneing we reqursevly quick sort all the numbers on the left and right side 5 58

    /**
     * Quick sort is a recursive algorithm where after we do the partitioning where we put all the numbers less then the pivot to the left and
     * all the numbers higher than the pivot to the right we recursively quick sort all the numbers in the left partition
     * and recursively quick sort all the numbers in the right partition.
     * That recursive step is why we need the low index and the high index. because When we tell it to recurively
     * sort the subarray we don't want to just tell it to recursively sort the entire array again so we pass in a range a low index and high index
     * of that particular subarray so that it can properly do the recursive quick sortsthat performs quick sort.
     * @param array
     * @param lowIndex
     * @param highIndex
     */
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        //this part is whean we are dealing with subarray of only one element
        if (lowIndex >= highIndex) {
            return;
        }
        /////////////////// 21 30
        //FIRST STEP is to choose a pivot.
        //We do this in order to take a random index somewhere in the middle because numbers are randomly divided
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
//        int pivot = array[highIndex];
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);//then we swap that element on random position with our last element

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    //used to move all elements less of the pivot on the left side,
    // and to move all elements grater then the pivot on the right side

    /**
     * Partitioning, this is the part where we have to move all the numbers lower than the pivot to the left of the pivot
     * and all the numbers higer than the pivot to the right of the pivot.
     * @param array array of elements that had to be sorted.
     * @param lowIndex represents left pointer, and it will iterate through the array from the left side one element at the time untill we
     *                 find an element that is larger than the pivot.
     * @param highIndex
     * @param pivot
     * @return
     */
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int righPointer = highIndex;

        while (leftPointer < righPointer) {
            //we are iterate through the array from the left side one element at the time to the right, untill we find an element
            //that is larger that the pivot.
            //And then we move on to right pointer and we will start
            //       iterate through the array from the right side one elemnt at the time to the left, untill we run to an element
            //that is less then the pivot.
            while (array[leftPointer] <= pivot && leftPointer < righPointer) {
                leftPointer ++;
            }
            while (array[righPointer] > pivot && leftPointer < righPointer) {
                righPointer --;
            }
            //at this point
            // our leftPointer is pointin to the number that is grater then a pivot
            // our rightPointer is pointint to a number that is less than our pivot
            //at this moment we will swap numbers from the left and right pointers and then we continue with process
            swap(array, leftPointer, righPointer);
        }
        //at this point left and right pointer show to the same element, and when that happens we want to stop that process  of
        //moving the left and right pinter toward each other, and we will swap our pivvot with the element that our left pointer is pointing to
        //and in this moment the iteration of partittioning is complete, and all elements that are less then our pivot are on pivots left side
        //and all elements that are grater then pivot aro to the right side.
        swap(array, leftPointer, highIndex);
        //after the partitioning happens were going to recursively quick sort the sub array to the left of our pivvot and
        //recurseviley quick sort the subarray to the right of pivot
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    private static void printArray(int[] arry) {
        for (int i = 0; i < arry.length; i++ ){
            System.out.print(arry[i] + " ");
        }
    }

}
