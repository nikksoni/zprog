package com.practice.custom.sort;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhilesh.Soni on 23-05-2017.
 */
public class Sort {

    public static void main(String[] args) {
        List<? extends Base> inputs = new ArrayList<>();
    }

    public static void mergeSort(Object[] inputs, int start, int end) {
        if (end - start < 2) {

        } else {
            int mid = (start + end) / 2;
            mergeSort(inputs, start, mid);
            mergeSort(inputs, mid + 1, end);
        }
    }

    private static void merge(Object[] input, int start, int mid, int end) {
        for(int i=start;i<end;i++){


        }

    }

    private static void swap(Object[] inputs, int i, int j) {
        if (i < inputs.length && j < inputs.length) {
            Object obj = inputs[i];
            inputs[i] = inputs[j];
            inputs[j] = obj;
        }
    }

}

