package com.epam.prejap.tetris.game;

import java.util.Arrays;

/**
 * The LineRemover class is responsible for removing every complete filled
 * row from game grid. The class includes methods for receiving
 * index of row from the grid to be removed and to remove filled row itself.
 *
 * @author Dawid Zaorski
 */
public class LineRemover {

    private byte[][] grid;

    /**
     * Answers an integer row index from 2d array of
     * game grid that's is fully filled.
     *
     * @return row index
     */
    int completeLineIndex() {
        int rowIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            boolean isLineFull = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == (byte) 0) {
                    isLineFull = false;
                    break;
                }
            }
            if (isLineFull) rowIndex = i;
        }
        return rowIndex;
    }

    void setGrid(byte[][] grid) {
        this.grid = grid;
    }

    /**
     * Causes the operations of removing full filled row
     * to be pass as long as all complete lines will be removed.
     *
     * @see #completeLineIndex()
     * @see #removeLine(int)
     */
    void act() {
        while (completeLineIndex() > 0) {
            removeLine(completeLineIndex());
        }
    }

    /**
     * Changes the grid by emptying filled row.
     * All rows above filled row are moved down expect
     * the first row, that will be filled with zeros.
     *
     * @param rowIndex the index of row to by removed
     * @see #completeLineIndex()
     */
    void removeLine(int rowIndex) {
        for (int i = rowIndex; i > 0; i--) {
            System.arraycopy(grid[i - 1], 0, grid[i], 0, grid[i].length);
        }
        Arrays.fill(grid[0], (byte) 0);
    }

    byte[][] getGrid() {
        return grid;
    }

}
