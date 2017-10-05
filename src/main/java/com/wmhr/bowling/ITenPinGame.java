/*
 This interface represents a game of Ten Pin Bowling in the real world,
 */
package com.wmhr.bowling;

import java.util.List;

/**
 *
 * @author mwherrera
 */
public interface ITenPinGame {

    void loadGameFromFile(String filePath);

    void calculateAllPlayScores();

    void printAll();

    List<BowlingGame> getGames();

}
