package com.santa;

import com.santa.day1.ElevatorParser;

/**
 * Test the output
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("New Floor: " + ElevatorParser.parse(Integer.parseInt(args[0]), args[1]));
        System.out.println("Basement on Instruction: " + ElevatorParser.notifyBasement(Integer.parseInt(args[0]), args[1]));
    }
}
