package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Main m = new Main();
        m.testSearch();
        System.out.print("\n\n\n\nSudoku solver");
        m.testSudokuSolver();
    }

    public void testSearch() {

        List<String> l = readFileInList("words.txt");

        SearchAlgo binarySearch = new SearchAlgoTimer(new BinarySearch());
        SearchAlgo linearSearch = new SearchAlgoTimer(new LinearSearch());

        String s = "hello";
        System.out.printf("\n\n\nLooking for work <%s>\n", s);
        binarySearch.find(l,s);
        linearSearch.find(l,s);

        s = "'re";
        System.out.printf("\n\n\nLooking for work <%s>\n", s);
        binarySearch.find(l,s);
        linearSearch.find(l,s);
    }

    public List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return lines;
    }

    public void testSudokuSolver() {
        new SudokuSolver(getSudokuExample()).solve();
    }
    public int[][] getSudokuExample() {
        return new int[][] {
                {0,0,0,0,0,2,1,0,0},
                {0,0,4,0,0,8,7,0,0},
                {0,2,0,3,0,0,9,0,0},
                {6,0,2,0,0,3,0,4,0},
                {0,0,0,0,0,0,0,0,0},
                {0,5,0,6,0,0,3,0,1},
                {0,0,3,0,0,5,0,8,0},
                {0,0,8,2,0,0,5,0,0},
                {0,0,9,7,0,0,0,0,0}
        };
    }
}
