package com.invoker.scanner.classes;

import com.invoker.annotation.MyMethodAnnotation;

/**
 * Created by Nikhilesh.Soni on 20-01-2017.
 */
public class TestClassInvoke {

    @MyMethodAnnotation
    public String sayHello(String a, String b) {
        System.out.println("hello : " + a);
        return a + b;
    }
}
