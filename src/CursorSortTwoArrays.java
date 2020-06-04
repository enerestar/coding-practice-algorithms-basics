import java.util.Arrays;

public class CursorSortTwoArrays {

    int[] arr1;
    int[] arr2;
    int m;
    int n;
    int arr1Length;

    public boolean hasPrevious() {
        return this.arr1Length > 0;
    }

    public void previous() {
        if (this.m == 0) {
            System.out.println(this.n - 1);
            System.out.println(this.arr1Length - 1);
            this.arr1[this.arr1Length - 1] = this.arr2[this.n - 1];
            this.n--;
        }
        if (this.m > 0) {
            if (this.arr1[this.m - 1] > this.arr2[this.n - 1]) {
                this.arr1[this.arr1Length] = this.arr1[this.m - 1];
                this.arr1[this.arr1Length - 1] = this.arr2[this.n - 1];
                this.m--;
            } else {
                this.arr1[this.arr1Length] = this.arr2[this.n - 1];
                this.arr1[this.arr1Length - 1] = this.arr1[this.m - 1];
                this.n--;
            }
            this.arr1Length--;
        }
        System.out.println(Arrays.toString(this.arr1));
    }
}
