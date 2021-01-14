package com.epam.prejap.tetris.game;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

@Test(groups = "Game")
public class LineRemoverTest {

    private final int ROWS = 10;
    private final int COLS = 20;

    private final byte[][] emptyGrid = new byte[ROWS][COLS];
    private final byte[][] inputGrid = new byte[ROWS][COLS];
    private final byte[][] middleGrid = new byte[ROWS][COLS];
    private final byte[][] outputGrid = new byte[ROWS][COLS];

    private final int[] FILLED_ROWS_INDEX = {2, 9};
    private final int[] FILLED_COLS_INDEX = {4, 8};

    @BeforeMethod
    public void setInputGrid() {
        for (int i = 0; i < emptyGrid.length; i++) {
            for (int j = 0; j < emptyGrid[i].length; j++) {
                inputGrid[i][j] = (byte) 0;
                if (i == FILLED_ROWS_INDEX[0] || i == FILLED_ROWS_INDEX[1] || j == FILLED_COLS_INDEX[0] || j == FILLED_COLS_INDEX[1]) {
                    inputGrid[i][j] = (byte) 1;
                }
            }
        }
    }

    @BeforeMethod
    public void setMiddleGrid() {
        for (int i = 1; i < emptyGrid.length; i++) {
            for (int j = 0; j < emptyGrid[i].length; j++) {
                middleGrid[i][j] = (byte) 0;
                if (i == FILLED_ROWS_INDEX[0] + 1 || j == FILLED_COLS_INDEX[0] || j == FILLED_COLS_INDEX[1]) {
                    middleGrid[i][j] = (byte) 1;
                }
            }
        }
    }

    @BeforeMethod
    public void setOutputGrid() {
        for (int i = 0; i < emptyGrid.length; i++) {
            for (int j = 0; j < emptyGrid[i].length; j++) {
                outputGrid[i][j] = (byte) 0;
                if (i >= FILLED_ROWS_INDEX.length && (j == FILLED_COLS_INDEX[0] || j == FILLED_COLS_INDEX[1])) {
                    outputGrid[i][j] = (byte) 1;
                }
            }
        }
    }

    @Test
    public void completeRowIndexShouldReturnZeroWhenGridIsEmpty() {
        //given
        LineRemover lineRemover = new LineRemover();

        //when
        lineRemover.setGrid(emptyGrid);

        //then
        assertEquals(lineRemover.completeLineIndex(), 0);
    }

    @Test
    public void completeRowIndexShouldReturnNonZeroWhenGridHaveCompleteLine() {
        //given
        LineRemover lineRemover = new LineRemover();

        //when
        lineRemover.setGrid(inputGrid);

        //then
        assertNotEquals(lineRemover.completeLineIndex(), 0);
    }

    @Test
    public void removeLineShouldRemoveOneCompleteLine() {
        //given
        LineRemover lineRemover = new LineRemover();

        //when
        lineRemover.setGrid(inputGrid);
        lineRemover.removeLine(FILLED_ROWS_INDEX[1]);

        //then
        assertTrue(Arrays.deepEquals(lineRemover.getGrid(), middleGrid));
    }

    @Test
    public void lineRemoverShouldRemoveAllCompleteLines() {
        //given
        LineRemover lineRemover = new LineRemover();

        //when
        lineRemover.setGrid(inputGrid);
        lineRemover.act();

        //then
        assertTrue(Arrays.deepEquals(lineRemover.getGrid(), outputGrid));
    }
}
