/*
 This class represent one bowling turn in the real world,
This class helps structure data entry.
 */
package com.wmhr.bowling;

/**
 *
 * @author mwherrera
 */
public class BowlingTurn implements IBowlingTurn{

    private String playerName;
    private String inputPinsDown;

    public BowlingTurn(String name, String inputPinsDown) {
        this.playerName = name;
        this.inputPinsDown = inputPinsDown;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String getInputPinsDown() {
        return inputPinsDown;
    }

}
