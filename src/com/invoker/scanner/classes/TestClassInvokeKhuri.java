package com.invoker.scanner.classes;

import com.invoker.annotation.MyMethodAnnotation;

/**
 * Created by Nikhilesh.Soni on 23-01-2017.
 */
public class TestClassInvokeKhuri {

    @MyMethodAnnotation
    public Integer getSum(Integer a, Integer b) {
        System.out.println("getSUmcalled with calue" + a + b);
        return a + b;
    }
}
