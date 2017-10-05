/*
This class represent one frame with 3 throws, in Ten Pin Bowling this is the last frame.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public class Frame10 extends Frame {

    protected Throws throw_3;

    public Frame10(int numberFrame, Throws throw_1, Throws throw_2, Throws throw_3) {
        this.numberFrame = numberFrame;
        this.throw_1 = throw_1;
        this.throw_2 = throw_2;
        this.throw_3 = throw_3;
        this.typeScoreFrame = TypeScoreFrame.NONE;

        int pinsDownR1 = this.throw_1.getPinsDown();
        int pinsDownR2 = this.throw_2.getPinsDown();
        int pinsDownR3 = this.throw_3.getPinsDown();

        if ((pinsDownR1 + pinsDownR2) == 10) {
            this.typeScoreFrame = TypeScoreFrame.SPARE;
        }
        if (pinsDownR1 == 10 && pinsDownR2 == 10 && pinsDownR3 == 10) {
            this.typeScoreFrame = TypeScoreFrame.STRIKE;
        }
        if (this.typeScoreFrame == TypeScoreFrame.NONE) {
            this.checkAndFix();
        }
        pinsDownR1 = this.throw_1.getPinsDown();
        pinsDownR2 = this.throw_2.getPinsDown();
        pinsDownR3 = this.throw_3.getPinsDown();
        this.score = pinsDownR1 + pinsDownR2 + pinsDownR3;
    }

    @Override
    public void printPinfalls() {
        String markRoll_1 = this.getMark(this.throw_1.getInputPinsDown());
        String markRoll_3 = this.getMark(this.throw_3.getInputPinsDown());

        if (this.typeScoreFrame == TypeScoreFrame.SPARE) {
            System.out.print(markRoll_1 + "\t/\t" + markRoll_3 + "\n");
        } else {
            String markRoll_2 = this.getMark(this.throw_2.getInputPinsDown());
            System.out.print(markRoll_1 + "\t" + markRoll_2 + "\t" + markRoll_3 + "\n");
        }
    }

}
