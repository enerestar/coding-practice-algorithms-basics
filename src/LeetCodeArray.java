import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeArray {

    public static void main(String[] args) {
        // given an array, find the longest consecutive ones
        findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});

        // given an array find how many of them contain an even number of digits
        findEvenNumbersOfDigits(new int[]{122, 4423, 1532, 1, 2, 33});

        // given an array of integers sorted in non-decreasing order
        // return the squares of each number sorted in non-decreasing order)
        findSortedSquares(new int[]{-7,-3,2,3,11});
    }

    static int[] findSortedSquares(int[] nums) {
        int squares;
        for (int i = 0; i< nums.length; i++) {
            squares = nums[i] * nums[i];
            nums[i] = squares;
        }
        System.out.println("before " + Arrays.toString(nums));
        sort(nums);
        System.out.println("after " + Arrays.toString(nums));
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
