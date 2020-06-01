public class Cursor {

    int from = 0;
    int to = 0;
    int[] arr = new int[]{};
    boolean isZero;
    boolean isRed;
    boolean isPreviousInToArrElemZero;

    public boolean hasPrevious() {
        return this.to > 0;
    }

    public void previous() {
        this.isZero = this.arr[this.from] == 0;
        if (!isZero) {
            this.to--;
            this.from--;
        } else {
            this.to--;
            this.isRed = this.isPreviousInToArrElemZero;
            if (this.isRed) {
                this.from--;
                this.isPreviousInToArrElemZero = false;
            } else {
                this.isPreviousInToArrElemZero = true;
            }
        }
        System.out.println("previous " + this.from + " " + this.to);
    }

    public boolean hasNext() {
        return this.to < this.arr.length - 1;
    }

    public void next() {
        this.isZero = this.arr[this.from] == 0;
        if (!isZero) {
            this.from++;
            this.to++;
        } else {
            this.to++;
            this.isRed = this.isPreviousInToArrElemZero;
            if (!this.isRed) {
                this.isPreviousInToArrElemZero = true;
            } else {
                this.from++;
                this.isPreviousInToArrElemZero = false;
            }
        }
        System.out.println("next " + this.from + " " + this.to);
    }
}
