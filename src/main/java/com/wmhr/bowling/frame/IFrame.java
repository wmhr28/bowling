/*
This interface allow make polymorphism.

That is, it allows the flexibility of using frames of more than 2 Throw as in the case of frame 10.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public interface IFrame {

    int getScore();

    int getNumberFrame();

    TypeScoreFrame getTypeScoreFrame();

    void setCumulativeScore(int cumulativeScore);

    int getCumulativeScore();

    int getPinsDownThrow_1();

    int getPinsDownThrow_2();

    void printPinfalls();

    void printScore();

    void checkAndFix();

}
