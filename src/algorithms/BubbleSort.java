package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("sorting_algo.BubbleSort");
        int[] arr = new int[]{3,2,1,4,5,3};
//        sorting_algo.BubbleSort bubbleSort = new sorting_algo.BubbleSort();
//        bubbleSort.sorting_algo.BubbleSort(arr);
//        bubbleSort.printArray(arr);
        BubbleSort.BubbleSortCS(arr);
        BubbleSort.sortingWithMaximumBribes(arr);
//        sorting_algo.BubbleSort.sorting_algo.BubbleSort(arr);
        System.out.println("Sorting array");
//        sorting_algo.BubbleSort.printArray(arr);
    }

    private static void BubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            System.out.println("i is : " + i);
            for (int j = 0; j < n-i-1; j++) {
                System.out.println("j is : " + j);
                if(arr[j] > arr[j+1]) {
                    // swap array[j+1] and array[j]
                    // swap adjacent int and current int's position
                    // put currentInt into a temporaryInt
                    int temp = arr[j];

                    // let currentInt to be adjacentInt because currentInt
                    // is greater than adjacentInt
                    arr[j] = arr[j+1];

                    // let adjacentInt now become the integer in temporary holding
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void sortingWithMaximumBribes(int[] arr) {
        int n = arr.length;
        List<Integer> totalBribes = new ArrayList<>();
        for(int i = 0; i < n-1; i++) {
//            System.out.println("i is "+ i);
            for (int j = 0; j < n-i-1; j++) {
                System.out.println("j is "+ j);
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("arr is "+ Arrays.toString(arr));

//                    if (j <= 2) {
//                        // count the total number of bribes in the entire queue
//                        totalBribes.add(j+1);
//                        System.out.println(totalBribes);
//                    }  else {
//                        System.out.println("Too chaotic");
//                        break;
//                    }
                }
            }
        }
    }

    private static void BubbleSortCS(int[] arr) {
        int n = arr.length;
        for (int i=0; i< n-1; i++) {
            for (int j=1; j<n-i+1; j++) {
                if(arr[j] < arr[j-1]) {
                    System.out.println("array j " + arr[j]);
                    System.out.println("array j-1 " + arr[j-1]);
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    System.out.println("arr is "+ Arrays.toString(arr));
                    arr[j-1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; ++i) {
            System.out.println(arr[i] + " ");
            System.out.println();
        }
    }
}
