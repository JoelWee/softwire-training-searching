package com.company;

import java.util.List;

public class LinearSearch implements SearchAlgo {
    public int find(List<String> l, String val) {
        System.out.print("Linear Search");
        for (int i = 0; i < l.size(); i++) {
            if (val.equals(l.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
