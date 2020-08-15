package random;

import java.util.*;

public class Agricole {

    public static void main(String arg[]) {
        System.out.println("helloo");
        int res = solution(13,13, new int[]{7,42,13,15,13,7,1});
        System.out.println(res);
    }

    static int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY)
                result = i;
        }
        return result;
    }


}
