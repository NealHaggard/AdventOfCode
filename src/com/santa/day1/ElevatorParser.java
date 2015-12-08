package com.santa.day1;

import java.util.Arrays;

/**
 * TODO: Put a good comment here
 *
 * @author Neal Haggard (nehagg)
 * @since 4.17
 */
public class ElevatorParser {
    public static int parse( int base, String instructions) {
        return instructions.chars().reduce(base, ElevatorParser::parseChar);
    }

    private static int parseChar(int base, int instruction) {
        if (instruction == ')') {
            return --base;
        } else if (instruction == '(') {
            return ++base;
        }
        System.out.println("parseChar:: base = [" + base + "], instruction = [" + instruction + "]");
        return base;
    }

    public static int notifyBasement(int base, String instructions) {
        int level = base;
        int index;


        for (index = 0; index < instructions.length() && level >= 0; index++) {
            level = parseChar(level, instructions.charAt(index));
        }

        if (level >= 0) {
            return -1;
        }

        return index;
    }
}
