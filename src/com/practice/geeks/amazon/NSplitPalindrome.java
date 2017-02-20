package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 19-02-2017.
 */
public class NSplitPalindrome {
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        char[] input = s.toCharArray();
        int[][] evenDP = new int[input.length][input.length];
        int[][] oddDp = new int[input.length][input.length];

        int[] output = new int[input.length];

        populateEvenDp(input, evenDP);
        populateOddDp(input, oddDp);

   /*     for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(oddDp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(evenDP[i][j] + " ");
            }
            System.out.println();
        }*/

        computeDpArray(evenDP, oddDp, output, output.length);
      /*  System.out.println();
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(output[i] + " ");
        }*/

        System.out.print("Answer: "+ output[output.length-1]);
    }

    private static void populateEvenDp(char[] input, int[][] evendp) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if ((i + 1 - j) >= 0 && (i + j) < input.length) {
                    if (input[i + j] == input[i + 1 - j]) {
                        if (j == 1) {
                            evendp[i][i + j]--;
                            evendp[i][i + 1 - j] = -evendp[i][i + j];
                        } else if (evendp[i][i + j - 1] != 0) {
                            evendp[i][i + j] = evendp[i][i + j - 1] - 1;
                            evendp[i][i + 1 - j] = -evendp[i][i + j];
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    private static void populateOddDp(char[] input, int[][] odddp) {
        for (int i = 0; i < input.length; i++) {
            odddp[i][i] = -1;
        }
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if ((i - j) >= 0 && (i + j) < input.length) {
                    if (input[i + j] == input[i - j]) {
                        if (odddp[i][i + j - 1] != 0) {
                            odddp[i][i + j] = odddp[i][i + j - 1] - 1;
                            odddp[i][i - j] = -odddp[i][i + j];

                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            odddp[i][i] = 1;
        }
    }

    private static void computeDpArray(int[][] even, int[][] odd, int[] output, int length) {
        for (int i = 0; i < length; i++) {
            if (even[i][0] > 0) {
                output[2 * even[i][0] - 1] = 1;
            }
            if (odd[i][0] > 0) {
                output[2 * (odd[i][0] - 1)] = 1;
            }
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (odd[j][i] > 0) {
                    output[i + 2 * (odd[j][i] - 1)] = min(output[i - 1] + 1, output[i + 2 * (odd[j][i] - 1)]);
                }
                if (even[j][i] > 0) {
                    output[i + 2 * even[j][i] - 1] = min(output[i - 1] + 1, output[i + 2 * even[j][i] - 1]);
                }
            }
        }

    }


    private static int min(int n, int m) {
        if (m == 0) return n;
        return n < m ? n : m;
    }
}
