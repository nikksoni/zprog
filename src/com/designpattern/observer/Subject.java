package com.designpattern.observer;

/**
 * Created by Nikhilesh.Soni on 22-09-2017.
 */
public interface Subject {

    void register(Observer observer);

    void deregister(Observer observer);

    void notifyAllObserver();

    Object getObserver(Observer observer);
}
