package com.designpattern.observer;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhilesh.Soni on 22-09-2017.
 */
public class Topic implements Subject {
    List<Observer> observers = new ArrayList<>();
    private static final Object MUTEX = new Object();

    @Override
    public void register(Observer observer) {
        synchronized (MUTEX) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    @Override
    public void deregister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
        }

    }

    @Override
    public void notifyAllObserver() {

    }

    @Override
    public Object getObserver(Observer observer) {
        return null;
    }
}
