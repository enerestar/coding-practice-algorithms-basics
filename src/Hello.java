import java.util.Arrays;
import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
//        int[] hi = {3,4,5,6,7,8};
//        System.out.println(Arrays.toString(rotLeft(hi1, 2)));
        int[] hi1 = {1,2,3,4,5};
        minimumBribes(hi1);
    }

    static int[] rotLeft(int[] a, int d) {
        int[] newArray = new int[a.length]; System.arraycopy(a, 0, newArray, (a.length - d), d);
        int destinationPos = 0; // where the copied items will be placed
        int srcPosition = d; // from where you start copying
        int length = a.length - d; // to where you end copying
        System.arraycopy(a, srcPosition, newArray, destinationPos, length);
        return newArray;
    }

    static void minimumBribes(int[] q) {
        System.out.println(Arrays.toString(q));
    }
}