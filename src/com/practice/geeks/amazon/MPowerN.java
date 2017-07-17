package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 07-05-2017.
 */
public class MPowerN {
    public static void main(String[] args) {

        System.out.print(powerFunction(3,5));

    }

    public static  int powerFunction(int m, int n) {
        if (m == 1) {
            return 1;
        } else if (n == 1) {
            return m;
        } else {
            int k = n % 2;
            int ans = powerFunction(m, n / 2);
            if (k == 0) {
                return ans * ans;
            } else return ans * ans * m;
        }

    }
}