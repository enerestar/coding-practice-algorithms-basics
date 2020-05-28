import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeArray {

    public static void main(String[] args) {
        // given an array, find the longest consecutive ones
        findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});

        // given an array find how many of them contain an even number of digits
        findEvenNumbersOfDigits(new int[]{122, 4423, 1532, 1, 2, 33});

        // given an array of integers sorted in non-decreasing order
        // return the squares of each number sorted in non-decreasing order)
        findSortedSquares(new int[]{-7,-3,2,3,11});

        /**  Array insertion */
        // loop decrement
        howLoopDecrementGoes(new int[]{1,2,3,4,5,6,7,8,9,10});

        // If element at last truncated array is int 0, to handle edge cases
        // not to have duplicates
        duplicateZeroInArray(new int[]{1,0,4,5,0,2,3,0,8,9,0,8,7,3});
        duplicateZeroUsingPermutation(new int[]{1,0,4,5,0,2,3,0,8,9,0,8,7,3});
    }

    static int[] duplicateZeroUsingPermutation(int[] a) {

        int[] dupArray = new int[a.length];
        int x = 0;
        int y = 0;
//        ArrayList<Integer> indexing = new ArrayList<>();
        for (int i = 0; i < a.length; i ++) {
//            indexing.add(x);
//            indexing.add(y);
            if (y >= a.length) {
                break;
            }
            dupArray[y] = a[i];
            if (a[i] == 0) {
//                indexing.add(x);
                y ++;
                if (y >= a.length) {
                    break;
                }
//                indexing.add(y);
                dupArray[y] = a[i];
            }
            x ++;
            y ++;
        }
        System.arraycopy(dupArray, 0, a, 0, a.length);
        return dupArray;
    }

    static int[] duplicateZeroInArray(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                count ++;
            }
        }
        for (int i = a.length - count - 1; i >= 0; i--) {
            // Since we know the number of zeros in array, we can shift the entire
            // array to the back without the last few digits that will be
            // taken over by duplicated zeros
            a[i + count] = a[i];
            if (a[i] == 0) {
                count--;
                a[i + count]  = a[i];
            }
        }
        return a;
    }

    static int[] howLoopDecrementGoes(int[] arr) {
//        System.out.println("Start " + Arrays.toString(arr));
        // Decrement loop starts from back of array to front
        // If we are attempting to copy the second last num to the last,
        // min int can only be int i = length of array - 1;
        // i >= 0 is where the loop is supposed to run until
        // i-- is just looping decrementally ie 9,8,7,6
        int lengthOfArray = arr.length - 1;
        for (int i = lengthOfArray - 1; i >= 0; i--) {
//            System.out.println("i " + i);
            arr[i +1] = arr[i];
//            System.out.println("Loop " + Arrays.toString(arr));
        }
        arr[0] = 30;
//        System.out.println("End " + Arrays.toString(arr));
        return arr;
    }

    static int[] findSortedSquares(int[] nums) {
        int squares;
        for (int i = 0; i< nums.length; i++) {
            squares = nums[i] * nums[i];
            nums[i] = squares;
        }
        sort(nums);
        return nums;
    }

    static int[] sort(int[] newArray) {
        int temp;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i] > newArray[j]) {
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    static int findEvenNumbersOfDigits(int[] nums) {
        int evenDigits;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            evenDigits = String.valueOf(nums[i]).length();
            if (evenDigits % 2 == 0) {
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int highest = 0;
        int before;
        for (int i = 0; i < nums.length; i++) {
            before = count;
            if (nums[i] == 1) {
                count ++;
                if (count > before && count > highest) {
                    highest = count;
                }
            } else {
                count = 0;
            }
        }
        return highest;
    }
}
