package com.threading.reentrace;

/**
 * Created by Nikhilesh.Soni on 07-05-2017.
 */
public class B  {


    public static synchronized void testPrint(){
        System.out.print("testprintB");
        A.testPrint();
    }
}
