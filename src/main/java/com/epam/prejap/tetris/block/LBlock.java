package com.epam.prejap.tetris.block;

import java.util.Arrays;

/**
 * The LBlock class represents block shape of "L" in tetris game.
 *
 * <p>Implementation note: It contains byte 2d array with '1' and '0',
 * arranged in a way to form required shape.
 *
 */
final class LBlock extends Block {

    private static final byte[][] IMAGE = {
            {1, 0},
            {1, 0},
            {1, 1},
    };

    LBlock() {
        super(IMAGE);
    }

    private LBlock(byte[][] image) {
        super(image);
    }

    @Override
    public Block copyWithImage(byte[][] image) {
        return new LBlock(image);
    }
}