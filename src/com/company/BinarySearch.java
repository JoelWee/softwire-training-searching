package com.company;

import java.util.List;

public class BinarySearch implements SearchAlgo {
    public int find(List<String> l, String val) {
        System.out.print("Binary Search");
        int start = 0;
        int end = l.size();

        while (start < end) {
            int mid = (start + end) / 2;
            String midVal = l.get(mid);

            if (midVal.equals(val)) {
                return mid;
            } else if (val.compareTo(midVal) < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
