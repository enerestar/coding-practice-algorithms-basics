import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,6,3,5,14,20,25,12,19,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {

        int mid = arr.length / 2;

        // For arrays that are odd, we handle with floor on left and ceil on right
        int leftArrlength = (int) Math.floor(mid);
        int rightArrLength = arr.length - leftArrlength;
        System.out.println(rightArrLength);

        int[] arrLeft = new int[leftArrlength];
        System.arraycopy(arr, 0, arrLeft, 0, leftArrlength);
        System.out.println(Arrays.toString(arrLeft));

        int[] arrRight = new int[rightArrLength];
        System.arraycopy(arr, leftArrlength, arrRight, 0, rightArrLength);
        System.out.println(Arrays.toString(arrRight));

        return new int[]{4,5,6};
    }

    public int[] mergeSort(int[] arr) {
        return new int[]{1,2,3};
    }

    public int[] merge() {
        return new int[]{2,3,4};
    }
}
