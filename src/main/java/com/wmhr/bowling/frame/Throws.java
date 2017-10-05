/*
This class is one of the main pieces of this game and represents the number of pins knocked down in one throws.
 */
package com.wmhr.bowling.frame;

/**
 *
 * @author mwherrera
 */
public class Throws implements IThrows {

    private String inputPinsDown;
    private int pinsDown;

    public Throws(String inputPinsDown) {
        this.inputPinsDown = inputPinsDown.trim();
        this.calculatePinsDown();
    }

    @Override
    public void setInputPinsDown(String inputPinsDown) {
        this.inputPinsDown = inputPinsDown;
        this.calculatePinsDown();
    }

    @Override
    public String getInputPinsDown() {
        return this.inputPinsDown;
    }

    @Override
    public int getPinsDown() {
        return this.pinsDown;
    }

    @Override
    public boolean IsInputPinsDownValid(String inputPinsDown) {
        if (inputPinsDown.equals("")) {
            return true;
        }
        return inputPinsDown.matches("^[0-9]|10|F$");
    }

    private void calculatePinsDown() {
        if (this.IsInputPinsDownValid(this.inputPinsDown)) {
            if (this.inputPinsDown.equals("") || this.inputPinsDown.equals("F")) {
                this.pinsDown = 0;
            } else {
                this.pinsDown = Integer.parseInt(this.inputPinsDown);
            }
        } else {
            this.pinsDown = 0;
            this.inputPinsDown = "";
        }
    }

}
