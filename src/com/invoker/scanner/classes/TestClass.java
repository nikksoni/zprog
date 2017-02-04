package com.invoker.scanner.classes;

import com.invoker.annotation.MyMethodAnnotation;
import com.invoker.annotation.MyInstanceAnnotation;

/**
 * Created by Nikhilesh.Soni on 20-01-2017.
 */
public class TestClass {

    @MyInstanceAnnotation
    private TestClassInvoke testClassInvoke;

    @MyMethodAnnotation
    public void sayHelloAgain(){
        System.out.println("start");
        String ans=testClassInvoke.sayHello("sam","sung");
        System.out.println("finish: "+ans);
        ans=testClassInvoke.sayHello("sam","sungua");
        System.out.println("finishing start: "+ans);
        ans=testClassInvoke.sayHello("sam","sung");
        System.out.println("finish final start: "+ans);
    }

}
