package com.invoker.scanner.classes;

import com.invoker.annotation.MyInstanceAnnotation;
import com.invoker.annotation.MyMethodAnnotation;

/**
 * Created by Nikhilesh.Soni on 23-01-2017.
 */
public class TestClassKhuri {

    @MyInstanceAnnotation
    private TestClassInvokeKhuri testClassInvokeKhuri;

    @MyMethodAnnotation
    public  void sayHello(){
        Integer sum=testClassInvokeKhuri.getSum(1,3);
        System.out.println("Sum  " +sum);
        sum=testClassInvokeKhuri.getSum(2,3);
        System.out.println("Sum  " +sum);
        sum=testClassInvokeKhuri.getSum(3,3);

        System.out.println("Sum"   +sum);

        sum=testClassInvokeKhuri.getSum(1,3);
        System.out.println("Sum  " +sum);
    }
}
