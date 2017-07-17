package com.threading.reentrace;

/**
 * Created by Nikhilesh.Soni on 07-05-2017.
 */
public class A {
    private A() {
    }

    public static synchronized void testPrint(){
        System.out.print("testprint");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
