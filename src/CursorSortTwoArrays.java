import java.util.Arrays;

public class CursorSortTwoArrays {

    int[] arr1;
    int[] arr2;
    Integer mIndex;
    Integer nIndex;
    int arr1Index;

    public boolean hasPrevious() {
        return this.arr1Index > -1;
    }

    public void previous() {
        if (mIndex == -1 && nIndex != -1) {
            nIndex--;
        }
        if (mIndex != -1 && nIndex == -1) {
            mIndex--;
        }
        if (mIndex >= 0 && nIndex >= 0) {
            if (this.arr1[mIndex] > this.arr2[nIndex]) {
                mIndex--;
            } else {
                nIndex--;
            }
        }
        this.arr1Index--;
    }

}