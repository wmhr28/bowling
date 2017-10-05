/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.bowling.frame;

import com.wmhr.bowling.TenPinGame;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author mwherrera
 */
public class TenPinGameTest {

    @Test
    public void checkGame1() {
        System.out.println("Start test Game 1");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game2.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(0).getScore();
        System.out.println("1.- game2.txt response score game 1 =170");
        assertThat(gameScore, equalTo(170));
    }

    @Test
    public void checkGame2() {
        System.out.println("Start test Game 2");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game2.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(1).getScore();
        System.out.println("2.- game2.txt response score game 2 =132");
        assertThat(gameScore, equalTo(132));
    }

    @Test
    public void checkGame3() {
        System.out.println("Start test Game 3");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game4.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(0).getScore();
        System.out.println("3.- game4.txt response score game 1 =175");
        assertThat(gameScore, equalTo(175));
    }

    @Test
    public void checkGame4() {
        System.out.println("Start test Game 4 perfect");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game_perfect.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(0).getScore();
        System.out.println("4.- game_perfect.txt response score game 1 =300");
        assertThat(gameScore, equalTo(300));
    }

    @Test
    public void checkGame5() {
        System.out.println("Start test Game 5 All F");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game_all_F.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(0).getScore();
        System.out.println("5.- game_perfect.txt response score game 1 =0");
        assertThat(gameScore, equalTo(0));
    }

    @Test
    public void checkGame6() {
        System.out.println("Start test Game 6 incomplete");
        String filePath = "C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game_incomplete.txt";
        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        int gameScore = objTen.getGames().get(0).getScore();
        System.out.println("6.- game_perfect.txt response score game 1 =30");
        assertThat(gameScore, equalTo(30));
    }
}
