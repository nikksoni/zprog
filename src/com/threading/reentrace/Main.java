package com.threading.reentrace;

/**
 * Created by Nikhilesh.Soni on 07-05-2017.
 */
public class Main {

    public static void main(String[] args){
    /*    B b = new B();
        A.testPrint();
        b.testPrint();*/
        Class a = A.class;
        try {
            A aa=(A)a.newInstance();
            aa.testPrint();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
