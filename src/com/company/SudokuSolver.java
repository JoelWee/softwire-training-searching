package com.company;

import java.util.*;

public class SudokuSolver {
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public void solve() {
        int[] rc = getNextPosition();
        if (rc == null && isValid()) {
            System.out.println("Solved!");
            print();
            return;
        }
        List<Integer> possibleMoves = getPossibleMoves(rc[0], rc[1]);
        int origMove = board[rc[0]][rc[1]];
        for (int move : possibleMoves) {
            board[rc[0]][rc[1]] = move;
            solve();
            board[rc[0]][rc[1]] = origMove;
        }
    }

    public List<Integer> getPossibleMoves(int row, int col) {
        Set<Integer> possibleMoves = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i++) {
            possibleMoves.remove(board[row][i]);
            possibleMoves.remove(board[i][col]);
        }

        int[] boxCoords = new int[]{(row / 3) * 3, (col / 3) * 3};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possibleMoves.remove(board[boxCoords[0] + i][boxCoords[1] + j]);
            }
        }

        return new ArrayList<>(possibleMoves);
    }

    public int[] getNextPosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public void print() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean isValid() {
        for(int i = 0; i<9; i++) {
            Set<Integer> seenC = new HashSet<>();
            Set<Integer> seenR = new HashSet<>();
            for (int j = 0; j<9; j++) {
                if(seenC.contains(board[i][j])) {
                    return false;
                }
                seenC.add(board[i][j]);

                if(seenR.contains(board[j][i])) {
                    return false;
                }
                seenR.add(board[j][i]);
            }
        }

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(!verifyBox(i*3,j*3)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean verifyBox(int row, int col) {
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                int val = board[row+i][col+j];
                if(seen.contains(val)) {
                    return false;
                }
                seen.add(val);
            }
        }
        return true;
    }
}
