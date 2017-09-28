package com.practice.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhilesh.Soni on 07-09-2017.
 */
public class LRUCache {
    private int size = 0;
    Map<Integer, Integer> dataMap;
    private int capacity;
    QNode start, last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>(capacity);
    }

    public void add(Integer key, Integer value) {
        Integer v = dataMap.get(key);
        if(size<capacity){

        }

        dataMap.put(key, value);
        if (v == null) {
            if (size < capacity) {

            }
        }

        proccedNodeToFront(key);
    }

    private void proccedNodeToFront(Integer key) {
        QNode start = this.start;
        if (start.key == key) {
            return;
        }
        while (start != last) {
            if (start.getKey() == key) {
                QNode toMove = start;
                toMove.previous.next = toMove.next;
                toMove.next.previous = toMove.previous;
                toMove.previous = null;
                toMove.next = start;
                this.start = toMove;
                start = last;
            } else {
                start = start.next;
            }
        }
        if (last.getKey() == key) {
            QNode toMove = this.last;
            this.last = last.previous;
            last.previous.next = null;
            toMove.next = this.start;
            toMove.previous = null;
            this.start = toMove;
        }
    }

}
