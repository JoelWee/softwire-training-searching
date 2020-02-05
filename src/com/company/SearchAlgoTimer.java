package com.company;

import java.util.List;

public class SearchAlgoTimer implements SearchAlgo {
    SearchAlgo algo;

    public SearchAlgoTimer (SearchAlgo algo) {
        this.algo = algo;
    }

    public int find(List<String> l, String val) {
        long startTime = System.nanoTime();
        int idx = algo.find(l, val);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000;

        System.out.printf(": %d microseconds\n", duration);
        return idx;
    }
}
