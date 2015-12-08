package com.santa.day1;

import java.util.stream.IntStream;

/**
 * --- Day 1: Not Quite Lisp ---
 * <p>
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor
 * - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the
 * instructions one character at a time.
 * <p>
 * An opening parenthesis, (, means he should go up one floor,
 * and a closing parenthesis, ), means he should go down one floor.
 * <p>
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 * <p>
 * For example:
 * <p>
 * (()) and ()() both result in floor 0.
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3.
 *
 * @author Neal Haggard
 */
public class ElevatorParser {
    public static int parse(int base, String instructions) {
        return instructions.chars().reduce(base, ElevatorParser::parseChar);
    }

    private static int parseChar(int base, int instruction) {
        if (instruction == ')') {
            return base - 1;
        } else if (instruction == '(') {
            return base + 1;
        }

        return base;
    }

    public static int notifyBasement(int base, String instructions) {
        return IntStream.range(0, instructions.length() + 1)
                .filter(i -> parse(base, instructions.substring(0, i)) < 0)
                .findFirst().orElse(-1);
    }
}
