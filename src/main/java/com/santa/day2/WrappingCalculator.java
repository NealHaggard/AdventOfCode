package com.santa.day2;

import static java.util.Arrays.stream;

/**
 * --- Day 2: I Was Told There Would Be No Math ---
 * <p>
 * The elves are running low on wrapping paper, and so they need to submit an order for more. They have a list of the
 * dimensions (length l, width w, and height h) of each present, and only want to order exactly as much as they need.
 * <p>
 * Fortunately, every present is a box (a perfect right rectangular prism), which makes calculating the required
 * wrapping paper for each gift a little easier: find the surface area of the box, which is 2*l*w + 2*w*h + 2*h*l.
 * The elves also need a little extra paper for each present: the area of the smallest side.
 * <p>
 * For example:
 * <p>
 * A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square feet of wrapping paper
 * plus 6 square feet of slack, for a total of 58 square feet.
 * <p>
 * A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square feet of wrapping paper
 * plus 1 square foot of slack, for a total of 43 square feet.
 * <p>
 * All numbers in the elves' list are in feet. How many total square feet of wrapping paper should they order?
 *
 * @author Neal Haggard
 */
public class WrappingCalculator {

    /**
     * Given an array of Strings representing the dimensions of a bunch of presents, figure out the total area of
     * wrapping paper needed to cover the presents.
     * <p>
     * Calculated from the 2 * area of each side plus slack equal to the area of the smallest side.
     *
     * @param input Array of strings
     * @return area in square feet of wrapping paper needed to cover all of the presents
     */
    public static int calculateTotalWrappingPaperArea(String[] input) {
        return stream(input).map(Present::new).mapToInt(WrappingCalculator::calculateNeededWrappingPaper).sum();
    }

    /**
     * Calculate the needed wrapping paper for one present, including slack based on the area of the smallest side.
     *
     * @param present Present
     * @return square feet needed to wrap the present
     */
    protected static int calculateNeededWrappingPaper(Present present) {
        return present.getDimensions().stream().mapToInt(dimension -> 2 * dimension.area()).sum() +
                present.getDimensions().stream()
                        .sorted((d1, d2) -> Integer.compare(d1.area(), d2.area()))
                        .findFirst()
                        .orElse(new Dimension())
                        .area();
    }
}
