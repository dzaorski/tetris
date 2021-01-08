package com.epam.prejap.tetris.block;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "BlockRotation")
public class BlockRotatorTest {

    @DataProvider
    public Object[][] pointsToRotate() {
        return new Object[][] {
                {new Point(0, 1), new Point(2,3 ), new Point(1, 2)},
        };
    }

    @Test(dataProvider = "pointsToRotate")
    public void shouldRotatePointOnRotatedImage(Point pointToRotate,
                                                Point rotatedImageSize,
                                                Point rotatedPoint) {
        // given
        var blockRotator = new BlockRotator(null);

        // when
        var result = blockRotator.rotatePointOnRotatedImage(pointToRotate, rotatedImageSize);

        // then
        assertEquals(result, rotatedPoint);
    }

    @Ignore
    public void shouldRotateBlock90DegreesClockwise() {
        // given
        BlockRotator blockRotator = new BlockRotator(null);
    }


}