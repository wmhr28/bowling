/*
This class represents a game of Ten Pin Bowling in the real world,
each game can have one or more Bowling Game,
currently this class allows to start the game from a file .txt that contains a set of turns.
 */
package com.wmhr.bowling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mwherrera
 */
public class TenPinGame implements ITenPinGame {

    private List<BowlingGame> games;

    public TenPinGame() {
        this.games = new ArrayList<>();
    }

    @Override
    public void loadGameFromFile(String filePath) {
        try {
            File objfile = new File(filePath);
            FileReader fileR = new FileReader(objfile);
            BufferedReader buffer = new BufferedReader(fileR);
            // Read the file .txt
            String line;
            List<BowlingTurn> listTurns = new ArrayList<>();
            while ((line = buffer.readLine()) != null) {
                //load all turns to list of turns
                String[] turn = line.split("\t");
                listTurns.add(new BowlingTurn(turn[0], turn[1]));
            }
            fileR.close();
            //get all list of unique players, to know when players are involved.
            List<String> uniquePlayers = listTurns.parallelStream().map(BowlingTurn::getPlayerName).distinct().collect(Collectors.toList());

            for (String playerName : uniquePlayers) {
                //For each player we get all their turns and create a Bowling Game.
                List<BowlingTurn> listTurnFilter = listTurns.parallelStream().filter(b -> b.getPlayerName().equals(playerName)).collect(Collectors.toList());
                BowlingGame game = new BowlingGame(playerName, listTurnFilter, TypeBowlingGame.TEN_PIN_BOWLING);
                this.games.add(game);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void calculateAllPlayScores() {
        this.games.forEach((game) -> {
            game.calculatePlayScore();
        });
    }

    @Override
    public void printAll() {
        /*Start Print Header*/
        System.out.print("Frame\t\t");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.print("10\n");
        /*End Print Header*/
        this.games.forEach((game) -> {
            game.print();
        });

    }

    @Override
    public List<BowlingGame> getGames() {
        return games;
    }

}
