package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 21-04-2017.
 */
public class NonContinuousSubArrayMaxSum {
    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 1, 20,3,2,4,3,32,234,32,24,23,5,2,45,23,-2,3,-223};
        int[][] arr = process(input);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("  " + arr[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] process(int[] input) {
        int size = input.length;
        int[][] myDpArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            myDpArray[0][i] = input[i];
            myDpArray[1][i] = input[i];
        }
        for (int i = 2; i < size; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                max = myDpArray[i - 1][j] > max ? myDpArray[i - 1][j] : max;
                myDpArray[i][j] = myDpArray[i - 1][j];
            }
            for (int j = i - 1; j < size; j++) {
                myDpArray[i][j] = myDpArray[i - 1][j];
            }
            myDpArray[i][i] = max + myDpArray[i - 1][i] > myDpArray[i - 2][i - 1] ? max + myDpArray[i - 1][i] : myDpArray[i - 2][i - 1];
        }
        return myDpArray;
    }
}
