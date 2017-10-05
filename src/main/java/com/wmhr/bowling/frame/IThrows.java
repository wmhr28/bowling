/*
This interface represents the number of pins knocked down in one throws.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public interface IThrows {

    void setInputPinsDown(String inputPinsDown);

    String getInputPinsDown();

    int getPinsDown();

    boolean IsInputPinsDownValid(String inputPinsDown);
}
