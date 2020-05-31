public class Cursor {

    int from = 0;
    int to = 0;
    int[] arr = new int[]{};
    boolean isZero;
    boolean isRed;
    boolean isBlack;
    boolean isPreviousInToArrElemZero;

    public boolean hasPrevious() {
        return this.arr[this.to] < this.arr.length;
//        return this.from > 0 && this.arr[this.to] < this.arr.length;
    }

    public void previous() {
        this.isZero = this.arr[this.to] == 0;
        // TODO why this.from starts with 1 less
        System.out.println("    " + this.arr[this.to]);
        System.out.println(this.to + " " + this.from);
        if (!isZero) {
            this.to--;
            this.from--;
            System.out.println("NOT ZERO");
        } else {
            this.to--;
            System.out.println("IS ZERO");
            this.isBlack = this.isPreviousInToArrElemZero;
            if (isBlack) {
                this.from--;
                System.out.println("BLACK");
                this.isPreviousInToArrElemZero = false;
            } else {
                System.out.println("RED");
                this.isPreviousInToArrElemZero = true;
            }
        }
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
    }
}
