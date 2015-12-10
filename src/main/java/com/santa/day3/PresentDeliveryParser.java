package com.santa.day3;

import java.util.HashSet;
import java.util.Set;

/**
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 * <p>
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * <p>
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls
 * him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v),
 * east (>), or west (<). After each move, he delivers another present to the house at his new location.
 * <p>
 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
 * and Santa ends up visiting some houses more than once. How many houses receive at least one present?
 * <p>
 * For example:
 * <p>
 * -  > delivers presents to 2 houses: one at the starting location, and one to the east.
 * -  ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 * -  ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 *
 * @author Neal Haggard
 */
public class PresentDeliveryParser {

    private Set<Home> homes = new HashSet<>();

    /**
     * Parse instructions and deliver presents.
     *
     * @param startX     Origin X
     * @param startY     Origin Y
     * @param directions directions to follow
     * @return number of homes that received at least one present
     */
    public int deliver(int startX, int startY, String directions) {
        Home current = new Home(startX, startY);
        homes.add(current);

        for (int index = 0; index < directions.length(); index++) {
            Home newHome = parseDir(current, directions.charAt(index));
            homes.add(newHome);
            current = newHome;
        }

        return homes.size();
    }

    /**
     * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver
     * presents with him.
     * *
     * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house),
     * then take turns moving based on instructions from the elf, who is eggnoggedly reading from the same script as
     * the previous year.
     * <p>
     * This year, how many houses receive at least one present?
     *
     * @param startX     Origin X
     * @param startY     Origin Y
     * @param directions directions to follow
     * @return number of homes that received at least one present
     */
    public int doubleDelivery(int startX, int startY, String directions) {
        Home santaCurrent = new Home(startX, startY);
        Home roboSantaCurrent = santaCurrent;
        homes.add(santaCurrent);

        for (int index = 0; index < directions.length(); index += 2) {
            Home newHome = parseDir(santaCurrent, directions.charAt(index));
            homes.add(newHome);
            santaCurrent = newHome;

            newHome = parseDir(roboSantaCurrent, directions.charAt(index + 1));
            homes.add(newHome);
            roboSantaCurrent = newHome;
        }

        return homes.size();
    }

    /**
     * Helper method that parses a direction and returns the new location from the base location.
     *
     * @param base Starting location
     * @param dir  direction to move
     * @return New location
     */
    protected Home parseDir(Home base, int dir) {
        switch (dir) {
            case '^':
                return new Home(base.getX() + 1, base.getY());
            case 'v':
                return new Home(base.getX() - 1, base.getY());
            case '<':
                return new Home(base.getX(), base.getY() + 1);
            case '>':
                return new Home(base.getX(), base.getY() - 1);
            default:
                return base;
        }
    }
}
