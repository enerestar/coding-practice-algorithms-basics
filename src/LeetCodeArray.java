import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCodeArray {

    public static void main(String[] args) {

        /**  Array Introduction */
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

        // Duplicate zero and move right if zero in array
        duplicateZeroInArray(new int[]{1,0,4,5,0,2,3,0,8,9,0,8,7,3});
        duplicateZeroUsingPermutation(new int[]{1,0,4,5,0,2,3,0,8,9,0,8,7,3});
        duplicateZeroUsingCursor();

        // Merge sorted array
//        sortTwoArrays(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        sortTwoArrays(new int[]{2,3,4,4,9,0,0,0,0,0}, 5, new int[]{1,1,5,6,9}, 5);
//        sortTwoArrays(new int[]{2,0}, 1, new int[]{1}, 1);
//        sortTwoArrays(new int[]{0}, 0, new int[]{1}, 1);
//        sortTwoArrays(new int[]{1}, 1, new int[]{0}, 0);
        sortTwoArraysUsingCursor(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6},3);


        /** Array Deletion */
        int[] nums = new int[]{2};
        int val = 3;
        removeElementsInArrayUsingCollection(val, nums);
        removeElementsInArrayUsingCursor(val, nums);

        int[] numsRemoveDups = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicatesFromSortedArray(numsRemoveDups);

        /** Searching an Array */

    }

    static int removeDuplicatesFromSortedArray(int[] nums) {
        int from = 0;
        int to = 0;
        int count = 0;
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((from + 1) == nums.length) {
                nums[to] = nums[from];
                count++;
            }
            else if (nums[from] != nums[from + 1]) {
                nums[to] = nums[from];
                count++;
                to++;
                from++;
            } else {
                from++;
            }
        }
//        System.out.println(count);
//        System.out.println(Arrays.toString(nums));
        return count;
    }


    static int removeElementsInArrayUsingCursor(int val, int[] nums) {
        int arrLength = nums.length;
        int from = 0;
        int to = 0;
        int count = 0;
        while(from < arrLength) {
            if (nums[from] != val) {
                nums[to] = nums[from];
                from++;
                to++;
                count++;
            } else {
                from++;
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(count);
        return count;
    }

    static int removeElementsInArrayUsingCollection(int val, int[] nums) {
        Instant start = Instant.now();
        Integer[] data = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        Collection<Integer> collection = Arrays.asList(data);
        Collection<Integer> result = collection.stream()
                .filter(e -> e != val)
                .collect(Collectors.toList());

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
//        System.out.println("Time: " + timeElapsed + "ms");
//        System.out.println(Arrays.toString(nums));
//        System.out.println(result.size());
        return result.size();
    }

    static int[] sortTwoArraysUsingCursor(int[] arr1, int m, int[] arr2, int n) {
        CursorSortTwoArrays c = new CursorSortTwoArrays();
        c.arr1 = arr1;
        c.mIndex = m - 1;
        c.arr2 = arr2;
        c.nIndex = n - 1;
        c.arr1Index = c.arr1.length - 1;
        while(c.hasPrevious()) {
            if (c.mIndex == -1 && c.nIndex != -1) {
                c.arr1[c.arr1Index] = c.arr2[c.nIndex];
            }
            if (c.mIndex != -1 && c.nIndex == -1) {
                c.arr1[c.arr1Index] = c.arr1[c.mIndex];
            }
            if (c.mIndex >= 0 && c.nIndex >= 0) {
                c.arr1[c.arr1Index] = Math.max(c.arr1[c.mIndex], c.arr2[c.nIndex]);
            }
            c.previous();
        }
        return c.arr1;
    }

    static int[] sortTwoArrays(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (second < 0 || first < 0) {
                break;
            }
            if (nums1[first] > nums2[second]) {
                nums1[i] = nums1[first];
                nums1[i-1] = nums2[second];
                first--;
            } else {
                nums1[i] = nums2[second];
//                nums1[i-1] = num
                second--;
            }
        }
        System.out.println(Arrays.toString(nums1));
        return nums1;
    }

    static int[] duplicateZeroUsingCursor() {
        CursorDuplicateZero c = new CursorDuplicateZero();
        c.arr = new int[]{0,0,3,4,0,5};
        while (c.hasNext()) {
            c.next();
        }
        while (c.hasPrevious()) {
            c.arr[c.to] = c.arr[c.from];
            c.previous();
        }
        return c.arr;
    }

    static int[] duplicateZeroUsingPermutation(int[] a) {

        int[] dupArray = new int[a.length];
        int x = 0;
        int y = 0;
        for (int i = 0; i < a.length; i ++) {
            if (y >= a.length) {
                break;
            }
            dupArray[y] = a[i];
            if (a[i] == 0) {
                y ++;
                if (y >= a.length) {
                    break;
                }
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
        int length = a.length -1;
        for (int i = length - count; i >= 0; i--) {
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
            arr[i +1] = arr[i];
        }
        arr[0] = 30;
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
