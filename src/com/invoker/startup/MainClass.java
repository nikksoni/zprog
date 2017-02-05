package com.invoker.startup;


import com.invoker.annotation.MyMethodAnnotation;
import com.invoker.scanner.classes.TestClassInvokeKhuri;
import com.invoker.scanner.classes.TestClassKhuri;
import com.invoker.annotation.MyInstanceAnnotation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhilesh.Soni on 20-01-2017.
 */
public class MainClass {

    private static Map<String, Map<String, Object>> myCache = new HashMap<String, Map<String, Object>>();

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestClassInvokeKhuri.class);
        enhancer.setCallback(new MethodInterceptor() {
                                 @Override
                                 public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                                     if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                                         String key = convertArgsToString(objects);
                                         String methodName = method.getName().toLowerCase();
                                         if (myCache.get(methodName) == null) {
                                             myCache.put(methodName, new HashMap<String, Object>());
                                         }
                                         if (myCache.get(methodName).get(key) == null) {
                                             System.out.println("key " +key );
                                             Object returnObj = methodProxy.invokeSuper(o, objects);
                                             myCache.get(methodName).put(key, returnObj);
                                         }
                                         return myCache.get(methodName).get(key);

                                     } else {
                                         return methodProxy.invokeSuper(o, objects);
                                     }
                                 }
                             }

        );
        TestClassInvokeKhuri proxy = (TestClassInvokeKhuri) enhancer.create();
//        System.out.println(proxy.invoker(null));


        Class testingClass = TestClassKhuri.class;
        Object c = new TestClassKhuri();
        for (Field f : testingClass.getDeclaredFields()) {
            if (f.isAnnotationPresent(MyInstanceAnnotation.class)) {
//                System.out.println("one again");
                System.out.println(f.getType());
                try {
                    f.setAccessible(true);
                    f.set(c, proxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        ((TestClassKhuri)c).sayHello();


       /* for (Method m : testingClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyMethodAnnotation.class)) {
//                System.out.println("one method again");
                try {
                    m.invoke(c);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }*/

    }

    private static String convertArgsToString(Object[] args) {
        StringBuilder key = new StringBuilder();
        if (args != null && args.length > 0) {
            for (Object o : args) {
                if (o instanceof String) {
                    key.append((String) o).append("_");
                }
                if (o instanceof Byte) {
                    key.append((Byte) o).append("_");
                }
                if (o instanceof Integer) {
                    key.append((Integer) o).append("_");
                }
                if (o instanceof Boolean) {
                    key.append((Boolean) o).append("_");
                }
            }
        }
        return key.toString();
    }

}
