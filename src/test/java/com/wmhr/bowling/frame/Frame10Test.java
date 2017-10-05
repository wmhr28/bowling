/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.bowling.frame;

import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author mwherrera
 */
public class Frame10Test {

    private static Frame10 obj;

    @Test
    public void checkTypeScore1() {
        System.out.println("Start unit test Check Constructor");
        Throws throw_1 = new Throws("");
        Throws throw_2 = new Throws("");
        Throws throw_3 = new Throws("");
        obj = new Frame10(1, throw_1, throw_2, throw_3);
        System.out.println("1.- input throw_1 and throw_2 = '' and throw_3 = '' check typeScoreFrame=NONE");
        assertThat(obj.getTypeScoreFrame(), equalTo(TypeScoreFrame.NONE));
    }

    @Test
    public void checkTypeScore2() {
        Throws throw_1 = new Throws("4");
        Throws throw_2 = new Throws("6");
        Throws throw_3 = new Throws("8");
        obj = new Frame10(1, throw_1, throw_2, throw_3);
        System.out.println("2.- input throw_1='4' and throw_2 = '6' and throw_3 = '8' check typeScoreFrame=SPARE");
        assertThat(obj.getTypeScoreFrame(), equalTo(TypeScoreFrame.SPARE));
    }

    @Test
    public void checkTypeScore3() {
        Throws throw_1 = new Throws("10");
        Throws throw_2 = new Throws("10");
        Throws throw_3 = new Throws("10");
        obj = new Frame10(1, throw_1, throw_2, throw_3);
        System.out.println("3.- input throw_1='10' and throw_2 = '10' and throw_3 = '10' check typeScoreFrame=STRIKE");
        assertThat(obj.getTypeScoreFrame(), equalTo(TypeScoreFrame.STRIKE));
    }

    @Test
    public void checkTypeScore4() {
        Throws throw_1 = new Throws("10");
        Throws throw_2 = new Throws("2");
        Throws throw_3 = new Throws("10");
        obj = new Frame10(1, throw_1, throw_2, throw_3); 
        System.out.println("4.- input throw_1='10' and throw_2 = '2' and throw_3 = '10' check typeScoreFrame=NONE");
        assertThat(obj.getTypeScoreFrame(), equalTo(TypeScoreFrame.NONE));
    }

    @Test
    public void checkScore1() {
        System.out.println("Start unit test Check Score");
        Throws throw_1 = new Throws("");
        Throws throw_2 = new Throws("");
        Throws throw_3 = new Throws("");
        obj = new Frame10(1, throw_1, throw_2, throw_3);
        System.out.println("1.- input throw_1 and throw_2 = '' and throw_3 = '' check score=0");
        assertThat(obj.getScore(), equalTo(0));
    }

    @Test
    public void checkScore2() {
        Throws throw_1 = new Throws("4");
        Throws throw_2 = new Throws("6");
        Throws throw_3 = new Throws("8");
        obj = new Frame10(1, throw_1, throw_2, throw_3);
        System.out.println("2.- input throw_1='4' and throw_2 = '6' and throw_3 = '8' check score=18");
        assertThat(obj.getScore(), equalTo(18));
    }

    @Test
    public void checkScore3() {
        Throws throw_1 = new Throws("10");
        Throws throw_2 = new Throws("10");
        Throws throw_3 = new Throws("10");
        obj = new Frame10(1, throw_1, throw_2, throw_3); 
        System.out.println("3.- input throw_1='10' and throw_2 = '10' and throw_3 = '10' check score=30");
        assertThat(obj.getScore(), equalTo(30));
    }

    @Test
    public void checkScore4() {
        Throws throw_1 = new Throws("10");
        Throws throw_2 = new Throws("2");
        Throws throw_3 = new Throws("10");
        obj = new Frame10(10, throw_1, throw_2, throw_3);  
        System.out.println("4.- input throw_1='10' and throw_2 = '2' and throw_3 = '10' check score=10");
        assertThat(obj.getScore(), equalTo(10));
    }
}
