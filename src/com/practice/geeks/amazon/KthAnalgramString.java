package com.practice.geeks.amazon;

import java.util.Scanner;

/**
 * Created by nikhilesh.soni on 22-06-2017.
 */
public class KthAnalgramString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] inps = inp.split(" ");
        String input = inps[0];
        int number = Integer.parseInt(inps[1]);
        int counterArr[] = new int[26];
        populateArr(counterArr, input);
        int length = input.length();
        int factorialArr[] = new int[length + 1];
        populateFactorial(factorialArr);

        printStr(factorialArr,counterArr,number,new StringBuilder(),0);

    }

    private static void populateArr(int[] arr, String input) {
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i) - 'a']++;
        }
    }

    private static void populateFactorial(int factorialArr[]) {
        factorialArr[0] = 1;
        for (int i = 1; i < factorialArr.length; i++) {
            factorialArr[i] = factorialArr[i - 1] * i;
        }
    }

    private static void printStr(int[] factorialArr, int[] counterArr, int position, StringBuilder builder, int existSum) {
        for (int i = 0; i < 26; i++) {
            if (counterArr[i] > 0) {
                counterArr[i]--;
                int val = totalNumAfterIndex(factorialArr, counterArr, existSum, position);
                if (val + existSum > position) {
                    int charVal = (int) 'a';
                    char a = (char) (charVal + i);
                    builder.append(a);
                    printStr(factorialArr, counterArr, position, builder, existSum);
                } else if (val + existSum == position) {
                    reversePopulate(builder, counterArr);
                    System.out.print(builder.toString());
                } else {
                    counterArr[i]++;
                    existSum+=val;
                }
            }
        }
    }

    private static int totalNumAfterIndex(int[] factorialArr, int[] counterArr, int existingSum, int postion) {
        int numerator = 0;
        int den = 1;
        for (int i = 0; i < 26; i++) {
            if (counterArr[i] > 0) {
                numerator+=counterArr[i];
                den *= counterArr[i];
            }
        }
        int val = factorialArr[numerator] / den;
        return val;
    }


    private static StringBuilder reversePopulate(StringBuilder build, int[] counterArr) {
        for (int i = 25; i >= 0; i--) {
            while (counterArr[i] > 0) {
                int charVal = (int) 'a';
                char a = (char) (charVal + i);
                build.append(a);
                counterArr[i]--;
            }
        }
        return build;
    }

}
