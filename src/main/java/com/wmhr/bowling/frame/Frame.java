/*
This class allows defining a common behavior for a frame (2 throws per frame),
Can not be instantiated and is a base class for working with frames.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public abstract class Frame implements IFrame {

    protected int numberFrame;
    protected Throws throw_1;
    protected Throws throw_2;
    protected int score;
    protected int cumulativeScore;
    protected TypeScoreFrame typeScoreFrame;

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public int getNumberFrame() {
        return this.numberFrame;
    }

    @Override
    public TypeScoreFrame getTypeScoreFrame() {
        return this.typeScoreFrame;
    }

    @Override
    public void setCumulativeScore(int cumulativeScore) {
        this.cumulativeScore = cumulativeScore;
    }

    @Override
    public int getCumulativeScore() {
        return this.cumulativeScore;
    }

    @Override
    public int getPinsDownThrow_1() {
        return this.throw_1.getPinsDown();
    }

    @Override
    public int getPinsDownThrow_2() {
        return this.throw_2.getPinsDown();
    }

    @Override
    public void printPinfalls() {
        String markRoll_1 = getMark(this.throw_1.getInputPinsDown());
        if (this.typeScoreFrame == TypeScoreFrame.STRIKE) {
            System.out.print("\t" + markRoll_1 + "\t");
        }
        if (this.typeScoreFrame == TypeScoreFrame.SPARE) {
            System.out.print(markRoll_1 + "\t/\t");
        }
        if (this.typeScoreFrame == TypeScoreFrame.NONE) {
            System.out.print(markRoll_1 + "\t" + getMark(this.throw_2.getInputPinsDown()) + "\t");
        }
    }

    @Override
    public void printScore() {
        if (this.numberFrame == 10) {
            System.out.print("\t" + this.cumulativeScore + "\n");
        } else {
            System.out.print("\t" + this.cumulativeScore + "\t");
        }

    }

    public String getMark(String pinsDown) {
        String resp = pinsDown;
        if (pinsDown.equals("10")) {
            resp = "X";
        }
        if (pinsDown.equals("")) {
            resp = "0";
        }
        return resp;
    }

    @Override
    public void checkAndFix() {
        /* This function allows you to repair frames that do not satisfy with the following rule:
         * each frame must have maximum 10 pins
        if it is an invalid frame, it resets the frame and set 0 pins.
         */
        if ((this.getPinsDownThrow_1() + this.getPinsDownThrow_2()) > 10) {
            this.throw_1.setInputPinsDown("");
            this.throw_2.setInputPinsDown("");
            this.cumulativeScore = 0;
            if (this.numberFrame != 10) {
                this.score = 0;
            }

            this.typeScoreFrame = TypeScoreFrame.NONE;
        }
    }

}
