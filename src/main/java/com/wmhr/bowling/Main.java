/*
This class launches the entire application and allow enter the file path to be processed.
 */
package com.wmhr.bowling;

import java.util.Scanner;

/**
 *
 * @author mwherrera
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String filePath = scanner.next();

        TenPinGame objTen = new TenPinGame();
        objTen.loadGameFromFile(filePath);
        objTen.calculateAllPlayScores();
        objTen.printAll();
    }

    // Reference https://www.youtube.com/watch?v=aBe71sD8o8c score=170
    //objTen.loadGame("C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game2.txt");          
    // Reference https://www.youtube.com/watch?v=YgIrYUGiVtc score=175
    // objTen.loadGame("C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game4.txt");
    // Reference example total=300
    // objTen.loadGame("C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game_perfect.txt");
    // Reference https://www.youtube.com/watch?v=l3_ZeTF97w8 score=137
    //objTen.loadGame("C:\\Users\\mwher\\Documents\\NetBeansProjects\\bowling\\src\\main\\resources\\game5.txt");
    // Reference https://www.youtube.com/watch?v=l3_ZeTF97w8 score=225
}
