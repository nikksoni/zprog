package com.thread;

/**
 * Created by Mohammad.Ansari1 on 25-01-2017.
 */
public class ThreadClass extends Thread {
    private Object notifyLock;
    private Object tobePrinted;

    public ThreadClass(Object tobePrinted, Object notifyLock) {
        this.notifyLock = notifyLock;
        this.tobePrinted = tobePrinted;
    }

    @Override
    public void run() {
        synchronized (tobePrinted) {
            try {
                tobePrinted.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(tobePrinted);
        synchronized (notifyLock) {
            notifyLock.notify();
        }
    }

    public static void main(String[] args) {
        System.out.print("start");
        String[] str = new String[20];
        for (int i = 0; i < str.length; i++) {
            str[i] = "" + i;
        }

        for (int i = 0; i < str.length; i++) {
            Thread thread = null;
            if (i == str.length - 1) {
                thread = new ThreadClass(str[i], str[i]);
            } else {
                thread = new ThreadClass(str[i], str[i + 1]);
            }

            thread.start();
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (str[0]) {
            str[0].notify();
        }
        synchronized (str[str.length - 1]) {
            try {
                str[str.length - 1].wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("exit");
    }
}
