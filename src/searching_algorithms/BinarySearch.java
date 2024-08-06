package searching_algorithms;

public class BinarySearch {
    public static void main(String[] args) {

        int[] example1 = {1, 3, 6, 7, 9, 10, 11, 12, 14, 15};
        System.out.println("Result example one = " + binarySearch(example1, 0));
        System.out.println("Result example one = " + binarySearch(example1, 9));
        System.out.println("Result example one = " + binarySearch(example1, 19));

        int[] example2 = {1, 2, 4, 5, 7, 9, 11};
        System.out.println("Result example two = " + binarySearch(example2, 0));
        System.out.println("Result example two = " + binarySearch(example2, 9));
        System.out.println("Result example two = " + binarySearch(example2, 19));

    }

    /**
     * Binary search returns position of the element from the array where element is located,
     * or -1 if element is not present.
     * Array had to be sorted and ordered, if it is not sorted we have to sort it first.
     * <p>
     * Example of valid array {1, 3, 5, 6, 9}
     * Example of bad array {1, 5, 3, 6, 9}
     *
     * @param numbers      array of numbers that will be used
     * @param numberToFind number that we are searching in the list
     * @return integer value that represents position of the searched element in the list,
     * or -1 if the searched value is not present in the array
     */
    private static int binarySearch(int[] numbers, int numberToFind) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer <= rightPointer) {
            // We start search from the middle element
            int middlePointer = (leftPointer + rightPointer) / 2;
            int middleNumber = numbers[middlePointer];

            //return the position where the target element was located
            if (numberToFind == middleNumber) {
                return middlePointer;
            }
            //move the RIGHT POINTER on the LEFT half of the list to narrow the search on the LEFT half of the array
            if (numberToFind < middleNumber) {
                rightPointer = middlePointer - 1;
            }
            //move the LEFT POINTER on the RIGHT half of the list to narrow the search on the RIGHT half of the array
            else {
                leftPointer = middlePointer + 1;
            }
        }
        return -1;
    }
}
