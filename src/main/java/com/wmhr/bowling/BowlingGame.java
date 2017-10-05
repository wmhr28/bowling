/*
This class represent any Bowling Game, It has one Player, the type of game and a set of frames.
its business logic is based on a temporary list of unprocessed turns,
these frames will calculate your score according to the type of game.
Note: Currently only the business logic has been developed for Ten Pin Bowling.
 */
package com.wmhr.bowling;

import com.wmhr.bowling.frame.*;
import java.util.*;

/**
 *
 * @author mwherrera
 */
public class BowlingGame implements IBowlingGame{

    private List<IFrame> frames;
    private Player player;
    private TypeBowlingGame typeBowlingGame;
    private List<BowlingTurn> tmpTurn; 
    

    public BowlingGame(String playerName, List<BowlingTurn> tmpTurn, TypeBowlingGame typeBowlingGame) {
        this.player = new Player(playerName);
        this.tmpTurn = tmpTurn;
        this.typeBowlingGame = typeBowlingGame;
        this.frames = new ArrayList<>();
    }

    @Override
    public void calculatePlayScore() {
        //Allows to calculate the score according to the type of game.
        if (typeBowlingGame == TypeBowlingGame.TEN_PIN_BOWLING) {
            this.loadFramesFormatTenPin();
            this.calculatePlayScoreFormatTenPin();
        }

    }

    /* Start business logic Ten Pin Bowling*/
    private void loadFramesFormatTenPin() {
        /* This function allows to load all the frames from the temporary turn*/
        Iterator<BowlingTurn> listTurn = this.tmpTurn.iterator();
        for (int i = 1; i <= 9; i++) {
            if (listTurn.hasNext()) {
                BowlingTurn turn = listTurn.next();
                String input = turn.getInputPinsDown();
                Throws throw_1 = new Throws(input);
                Throws throw_2 = new Throws("");
                if (!input.equals("10")) {
                    if (listTurn.hasNext()) {
                        turn = listTurn.next();
                        throw_2.setInputPinsDown(turn.getInputPinsDown());
                    }
                }
                Frame1_9 frame = new Frame1_9(i, throw_1, throw_2);
                this.frames.add(frame);
            }
        }
        if (listTurn.hasNext()) {
            BowlingTurn turn = listTurn.next();
            Throws throw_1 = new Throws(turn.getInputPinsDown());
            Throws throw_2 = new Throws("");
            Throws throw_3 = new Throws("");
            if (listTurn.hasNext()) {
                turn = listTurn.next();
                throw_2.setInputPinsDown(turn.getInputPinsDown());
            }
            if (listTurn.hasNext()) {
                turn = listTurn.next();
                throw_3.setInputPinsDown(turn.getInputPinsDown());
            }
            Frame10 frame = new Frame10(10, throw_1, throw_2, throw_3);
            this.frames.add(frame);
        }
        this.completeFramesFormatTenPin();
    }

    private void completeFramesFormatTenPin() {
        /* This function allows you to repair the missing frames on the sheet Ten Pin Bowling. */
        int size = this.frames.size()+1;
        for (int i = size; i <= 9; i++) {
            Throws throw_1 = new Throws("");
            Throws throw_2 = new Throws("");
            Frame1_9 frame = new Frame1_9(i, throw_1, throw_2);
            this.frames.add(frame);
        }
        size = this.frames.size();
        if (size==9) {
            Throws throw_1 = new Throws("");
            Throws throw_2 = new Throws("");
            Throws throw_3 = new Throws("");
            Frame10 frame = new Frame10(10, throw_1, throw_2, throw_3);
            this.frames.add(frame);
        }
    } 

    private void calculatePlayScoreFormatTenPin() { 
        /* This function allows to calculate the score of each frame according to the rules of the play of Ten Pin Bowling,
        Here the cumulative score of each frame is calculated and assigned.
        */
        for (IFrame frame : this.frames) {
            int nFrame = frame.getNumberFrame();
            int cumulativeScorePrev = 0;
            if (nFrame > 1) {
                // get the score of the previous frame to sum to the current frame.
                cumulativeScorePrev = this.frames.get(nFrame - 2).getCumulativeScore();
            }
            if (nFrame < 8) {
                /*if the number of Frame is less than 8,
                can use the recursive function to calculate the cumulative score when is strike.*/
                int scoreNext = 0;
                if (frame.getTypeScoreFrame() == TypeScoreFrame.SPARE && nFrame < 10) {
                    scoreNext = this.frames.get(nFrame).getPinsDownThrow_1();
                }
                frame.setCumulativeScore(calculateStrikeFormatTenPin(frame, this.frames, 1) + scoreNext + cumulativeScorePrev);
            } else {
                /*For frames 8, 9 and 10 particular programming is required because the position
                does not allow that can be done with recursivity in an optimal and understandable way. */
                if (nFrame == 8) {
                    IFrame frame9 = this.frames.get(8);
                    int score9 = 0;
                    int score10 = 0;
                    if (frame.getTypeScoreFrame() != TypeScoreFrame.NONE) {
                        score9 = frame9.getPinsDownThrow_1();
                    }
                    if (score9 > 0) {
                        IFrame frame10 = this.frames.get(9);
                        if (frame9.getTypeScoreFrame() == TypeScoreFrame.STRIKE && frame.getTypeScoreFrame() == TypeScoreFrame.STRIKE) {
                            score10 = frame10.getPinsDownThrow_1();
                        }
                    }
                    frame.setCumulativeScore(frame.getScore() + score9 + score10 + cumulativeScorePrev);
                }
                if (nFrame == 9) {
                    int score10_1 = 0;
                    int score10_2 = 0;
                    if (frame.getTypeScoreFrame() != TypeScoreFrame.NONE) {
                        IFrame frame10 = this.frames.get(9);
                        score10_1 = frame10.getPinsDownThrow_1();
                        score10_2 = frame10.getPinsDownThrow_2();
                    }
                    frame.setCumulativeScore(frame.getScore() + score10_1 + score10_2 + cumulativeScorePrev);
                }
                if (nFrame == 10) {
                    frame.setCumulativeScore(frame.getScore() + cumulativeScorePrev);
                }
            }
        }

    }

    private int calculateStrikeFormatTenPin(IFrame frame, List<IFrame> listFrames, int n) {
        /*This recursive function return the score cumulative of the frame with strikes.
        can only accumulate maximum 2 times, and only can accumulate up to frame 9.
        */
        if (n == 3 || frame.getNumberFrame() == 9 || frame.getTypeScoreFrame() != TypeScoreFrame.STRIKE) {
            return frame.getScore();
        } else {
            //Is Strike
            return frame.getScore() + calculateStrikeFormatTenPin(listFrames.get(frame.getNumberFrame()), listFrames, n + 1);
        }
    }

    /* End business logic Ten Pin Bowling*/
    
    
    @Override
    public void print() {
        System.out.print(this.player.getName() + "\n");
        System.out.print("Pinfalls\t");
        this.frames.forEach((frame) -> {
            frame.printPinfalls();
        });
        System.out.print("Score\t");
        this.frames.forEach((frame) -> {
            frame.printScore();
        });
    }

    @Override
    public int getScore() {
        return this.frames.get(9).getCumulativeScore();
    }
    
}
