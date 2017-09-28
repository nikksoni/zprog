package com.btree;

/**
 * Created by Nikhilesh.Soni on 13-08-2017.
 */
public class B {

    private B() {
        System.out.println(Thread.currentThread().getName());
        printB();
    }

    public void printB(){
        System.out.println("B");
        System.out.println(Thread.currentThread().getName());
        printBB();
    }

    public void printBB(){
        System.out.println("BB");
    }
}
