package com.practice.topcoder;

/**
 * Created by Nikhilesh.Soni on 07-02-2017.
 */

/**
 * Problem Statement for LinenCenterEasy
 * <p>
 * <p>
 * Problem Statement
 * <p>
 * A few days ago, you won a tour of a textile factory. (Chocolate factory tours were deemed too risky to children and therefore banned). As everyone knows, textile is made of strings, so it's time to solve a string problem!
 * <p>
 * <p>
 * <p>
 * You are given a String S of length L. For any string T, we can now define its covering number c(T) as the maximum number of non-overlapping occurrences of S in T. Each occurrence must be a contiguous substring of T, and they may not share any letters.
 * <p>
 * <p>
 * <p>
 * Examples:
 * <p>
 * If S="ab", we have c("xyz")=0 and c("ababxab")=3.
 * <p>
 * If S="aaa", we have c("aa")=0 and c("aaaaaa")=2.
 * <p>
 * <p>
 * <p>
 * In addition to S, you are given two ints N and K.
 * <p>
 * <p>
 * <p>
 * Consider all strings with the following properties:
 * <p>
 * Each character of the string is a lowercase English letter ('a'-'z').
 * The length of the string is between L*K and L*K+N, inclusive.
 * The covering number of the string is exactly K.
 * Let X be the number of strings with the above properties. Since X may be large, compute and return the value (X modulo 1,000,000,009).
 * <p>
 * <p>
 * Definition
 * <p>
 * Class:	LinenCenterEasy
 * Method:	countStrings
 * Parameters:	String, int, int
 * Returns:	int
 * Method signature:	int countStrings(String S, int N, int K)
 * (be sure your method is public)
 * <p>
 * <p>
 * Constraints
 * -	N will be between 0 and 50, inclusive.
 * -	K will be between 0 and 50, inclusive.
 * -	L will be between 1 and 50, inclusive.
 * -	S will contain exactly L characters.
 * -	S will contain only lowercase English letters.
 * <p>
 * Examples
 * 0)
 * <p>
 * "xy"
 * 2
 * 1
 * Returns: 2079
 * There are 2027 strings of length 4, 52 strings of length 3 and one string of length 2 containing "xy" as a substring. One of them, "xyxy", has covering number 2, so we don't count it.
 * <p>
 * 1)
 * <p>
 * "q"
 * 2
 * 1
 * Returns: 1926
 * We're counting strings containing exactly one character 'q' and at most two other characters. There's one such string of length 1 ("q"), 2*25=50 of length 2 and 3*25^2=1875 of length 3.
 * <p>
 * 2)
 * <p>
 * "ababab"
 * 5
 * 4
 * Returns: 527166180
 * Watch out for integer overflows and make sure you are using the correct modulus!
 * <p>
 * 3)
 * <p>
 * "fgcdx"
 * 10
 * 3
 * Returns: 586649223
 * 4)
 * <p>
 * "ghjhhhgjhjhgjhghghjhjg"
 * 8
 * 10
 * Returns: 192161304
 * 5)
 * <p>
 * "pdpfrpfdfdpfdpfdpfpdfldfpfldpfe"
 * 49
 * 25
 * Returns: 164673990
 * 6)
 * <p>
 * "a"
 * 7
 * 0
 * Returns: 357828722
 * 7)
 * <p>
 * "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
 * 50
 * 50
 * Returns: 960113657
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
 * <p>
 * <p>
 * <p>
 * <p>
 * This problem was used for:
 * Single Round Match 692 Round 1 - Division II, Level Three
 */
public class LinenCenterEasy {

    public static void main(String[] args) {
        String s = "aasdfghjk";
        int l = s.length();
        int n = 2, k = 2;


    }

    private int populateCount(int k, int l, int n) {

        return 0;
    }

    private static int nCr(int n, int r) {
        if (n < r) {
            return 0;
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    //can also populate through DP pre processing
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
