package org.axp.medium;

import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://leetcode.com/problems/spiral-matrix-ii/description/
public class _59_SpiralMatrixII {

    public static void main(String[] args) {
        int n = 100;
        int[][] ints = new _59_SpiralMatrixII().generateMatrix(n);

        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < n; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println("]");
        }
        System.out.println();
        System.out.println(ints);

    }

    public int[][] generateMatrix(int n) {

        int[][] ints = new int[n][n];
        boolean fill = false;
        var index = new i2D(0, 0);
        int count = 1;
        var currentDirection = Direction.RIGHT;
        do {
            fill = tryFillCell(ints, index, count);
            count++;
            currentDirection = tryMove(ints, index, currentDirection);
            index = updateIndex(currentDirection, index);
        } while (fill);
        return ints;
    }

    private i2D updateIndex(Direction currentDirection, i2D index) {
        return switch (currentDirection) {
            case RIGHT -> new i2D(index.r, index.c+1);
            case DOWN -> new i2D(index.r+1, index.c);
            case LEFT -> new i2D(index.r, index.c-1);
            case UP -> new i2D(index.r-1, index.c);
        };
    }

    private Direction tryMove(int[][] ints, i2D index, Direction currentDirection) {
        return switch (currentDirection) {
            case RIGHT -> {
                if (index.c < ints.length-1 && ints[index.r][index.c + 1] == 0) {
                    yield Direction.RIGHT;
                } else {
                    yield Direction.DOWN;
                }
            }
            case DOWN -> {
                if (index.r < ints.length-1 && ints[index.r+1][index.c] == 0) {
                    yield Direction.DOWN;
                } else {
                    yield Direction.LEFT;
                }
            }
            case LEFT -> {
                if (index.c > 0 && ints[index.r][index.c - 1] == 0) {
                    yield Direction.LEFT;
                } else {
                    yield Direction.UP;
                }
            }
            case UP -> {
                if (index.r > 0 && ints[index.r -1][index.c] == 0) {
                    yield Direction.UP;
                } else {
                    yield Direction.RIGHT;
                }
            }
        };
    }

    private boolean tryFillCell(int[][] ints, i2D index, int count) {
        if (index.r < ints.length && index.c < ints.length && ints[index.r][index.c] == 0) {
            ints[index.r][index.c] = count;
            return true;
        }
        return false;
    }

    record i2D (int r, int c) {}
    enum Direction {RIGHT, DOWN, LEFT, UP}

}
