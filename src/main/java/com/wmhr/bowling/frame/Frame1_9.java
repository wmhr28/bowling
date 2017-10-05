/*
This class represents frames 1 - 9, in the case of Ten Pin Bowling these have 2 Throws.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public class Frame1_9 extends Frame {

    public Frame1_9(int numberFrame, Throws throw_1, Throws throw_2) {
        this.numberFrame = numberFrame;
        this.throw_1 = throw_1;
        this.throw_2 = throw_2;
        this.typeScoreFrame = TypeScoreFrame.NONE;
        this.checkAndFix();
        int pinsDownR1 = this.throw_1.getPinsDown();
        int pinsDownR2 = this.throw_2.getPinsDown();
        this.score = pinsDownR1 + pinsDownR2;
        if (pinsDownR1 == 10) {
            this.typeScoreFrame = TypeScoreFrame.STRIKE;
        } else {
            if (pinsDownR2 > 0 && this.score == 10) {
                this.typeScoreFrame = TypeScoreFrame.SPARE;
            }
        }
    }

}
