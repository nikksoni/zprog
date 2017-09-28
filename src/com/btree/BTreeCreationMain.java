package com.btree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Nikhilesh.Soni on 20-09-2017.
 */
public class BTreeCreationMain {

//    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//
//    }

    public void hello() {
        synchronized (BTreeCreationMain.this) {

        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
//        B  instanceOne =
//                EagerInitializedSingleton.getInstance();
        B instanceTwo = null;
        try {
            Constructor[] constructors =
                    B.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
//Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (B)
                        constructor.newInstance();
                System.out.println(instanceTwo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
