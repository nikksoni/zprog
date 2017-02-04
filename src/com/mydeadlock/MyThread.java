package com.mydeadlock;

/**
 * Created by Nikhilesh.Soni on 31-01-2017.
 */
public class MyThread implements Runnable {
    private Object test = new Object();
    private Object test2 = new Object();


    @Override
    public void run() {
        synchronized (test){
            test2.notifyAll();
            try {
                test.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
