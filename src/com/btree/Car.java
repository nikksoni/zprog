package com.btree;

/**
 * Created by Nikhilesh.Soni on 14-09-2017.
 */


import java.util.*;

public class Car {
    public static void main(String[] args) {
        String[] sa = {"nickel", "button", "key", "lint"};
        Sorter s = new Car().new Sorter();
        for (String s2 : sa) System.out.print(s2 + " ");
        Arrays.sort(sa, s);
        System.out.println();
        for (String s2 : sa) System.out.print(s2 + " ");
    }

    class Sorter implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}