package com.mydeadlock;

/**
 * Created by Nikhilesh.Soni on 31-01-2017.
 */
public class MyThread extends Thread{
    private Object test;
    private Object test2;

    public MyThread(Object test, Object test2) {
        this.test = test;
        this.test2 = test2;
    }

    @Override
    public void run() {
        synchronized (test) {
            System.out.println("Entered l1 by" +Thread.currentThread().getName());
            test.notifyAll();
            synchronized (test2) {
                System.out.println("Entered l2 by" +Thread.currentThread().getName());
                try {
                    test2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("lock up");

            }
        }
    }
}
