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
public class ThrowsTest {

    private static Throws obj;

    @BeforeClass
    public static void init() {
        obj = new Throws("");
    }

    @Test
    public void IsInputPinsDownValid1() {
        System.out.println("Start unit test Is a Input Pins Down Valid");
        System.out.println("valid is [0-10] F or ''");
        System.out.println("1.- input '1' return true");
        assertThat(obj.IsInputPinsDownValid("1"), equalTo(true));
    }

    @Test
    public void IsInputPinsDownValid2() {
        System.out.println("2.- input '11' return false");
        assertThat(obj.IsInputPinsDownValid("11"), equalTo(false));
    }

    @Test
    public void IsInputPinsDownValid3() {
        System.out.println("3.- input 'A' return false");
        assertThat(obj.IsInputPinsDownValid("A"), equalTo(false));
    }

    @Test
    public void IsInputPinsDownValid4() {
        System.out.println("4.- input 'F' return true");
        assertThat(obj.IsInputPinsDownValid("F"), equalTo(true));
    }

    @Test
    public void calculatePinsDown1() {
        System.out.println("Start unit test calculatePinsDown()");
        System.out.println("1.- input '' return 0");
        assertThat(obj.getPinsDown(), equalTo(0));
    }

    @Test
    public void calculatePinsDown2() {
        System.out.println("Start unit test calculatePinsDown()");
        System.out.println("2.- input '2' return 2");
        obj.setInputPinsDown("2");
        assertThat(obj.getPinsDown(), equalTo(2));
    }

    @Test
    public void calculatePinsDown3() {
        System.out.println("Start unit test calculatePinsDown()");
        System.out.println("3.- input 'A' return 0");
        obj.setInputPinsDown("A");
        assertThat(obj.getPinsDown(), equalTo(0));
    }

    @Test
    public void calculatePinsDown4() {
        System.out.println("Start unit test calculatePinsDown()");
        System.out.println("4.- input 'F' return 0");
        obj.setInputPinsDown("F");
        assertThat(obj.getPinsDown(), equalTo(0));
    }

}
