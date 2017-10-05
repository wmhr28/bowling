/*
This class helps structure information, represent the player in the real world.
 */
package com.wmhr.bowling;

/**
 *
 * @author mwherrera
 */
public class Player implements IPlayer{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
