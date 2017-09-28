package com.designpattern.observer;

/**
 * Created by Nikhilesh.Soni on 22-09-2017.
 */
public interface Observer {

    void update();

    void setSubject(Subject subject);
}
