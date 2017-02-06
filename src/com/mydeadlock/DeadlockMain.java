package com.mydeadlock;

/**
 * Created by Nikhilesh.Soni on 31-01-2017.
 */
public class DeadlockMain {

    public static  void main (String[] args){
        Object lock1 = new Object();
        Object lock2 =new Object();
        MyThread t1 =new MyThread(lock1,lock2);
        MyThread t2 =new MyThread(lock2,lock1);

        t1.start();
        t2.start();
    }


}
