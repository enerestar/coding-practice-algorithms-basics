package algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,6,3,5,14,20,25,12,19,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {

        // Do nothing if arr contains only 1 obj
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;

        // For arrays that are odd, we handle with floor on left
        int leftArrlength = (int) Math.floor(mid);
        int rightArrLength = arr.length - leftArrlength;

        int[] arrLeft = new int[leftArrlength];
        System.arraycopy(arr, 0, arrLeft, 0, leftArrlength);

        int[] arrRight = new int[rightArrLength];
        System.arraycopy(arr, leftArrlength, arrRight, 0, rightArrLength);

        sort(arrLeft);
        sort(arrRight);

        merge(arrLeft, arrRight, arr);
        return arr;
    }

    public static void merge(int[] arrLeft, int[] arrRight, int[] arr) {

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arrLeft.length && j < arrRight.length) {
            if (arrLeft[i] <= arrRight[j]) {
                arr[k++] = arrLeft[i++];
            } else {
                arr[k++] = arrRight[j++];
            }
        }
        while (i < arrLeft.length) {
            arr[k++] = arrLeft[i++];
        }
        while (j < arrRight.length) {
            arr[k++] = arrRight[j++];
        }
    }
}
