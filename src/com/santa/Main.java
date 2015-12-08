package com.santa;

import com.santa.day1.ElevatorParser;

public class Main {

    public static void main(String[] args) {
        System.out.println(ElevatorParser.parse(Integer.parseInt(args[0]), args[1]));
    }
}
