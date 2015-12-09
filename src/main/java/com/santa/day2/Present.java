package com.santa.day2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.stream;

/**
 * A present, a perfect rectangular cube.
 *
 * @author Neal Haggard
 */
public class Present {

    private List<Dimension> dimensions;

    /**
     * Construct a present from a set of dimensions lxwxh.
     *
     * @param input String holding the size of the present in the form lxwxh, in feet
     */
    public Present(String input) {
        Integer[] parsedDims = stream(input.split("x"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Dimension dim1 = new Dimension(parsedDims[0], parsedDims[1]);
        Dimension dim2 = new Dimension(parsedDims[1], parsedDims[2]);
        Dimension dim3 = new Dimension(parsedDims[2], parsedDims[0]);
        dimensions = newArrayList(dim1, dim2, dim3);
    }

    /**
     * Get the amount of wrapping paper needed to wrap the given present.
     *
     * @return amount of wrapping paper needed in square feet
     */
    public int wrappingPaperNeeded() {
        return dimensions.stream().mapToInt(dimension -> 2 * dimension.area()).sum() +
                dimensions.stream()
                        .sorted((d1, d2) -> Integer.compare(d1.area(), d2.area()))
                        .findFirst()
                        .orElse(new Dimension())
                        .area();
    }

    /**
     * Calculate the amount of ribbon needed.  Length of shortest perimeter + bow (volume of box).
     *
     * @return length of ribbon needed in feet.
     */
    public int ribbonNeeded() {
        return volume() + shortestPerimeter();
    }

    /**
     * Figure out the volume of the present.
     *
     * @return volume in cubic feet
     */
    protected int volume() {
        return dimensions.stream().mapToInt(Dimension::getX).reduce(1, (total, side) -> total * side);
    }

    /**
     * Figure out the shortest perimeter for the present.
     *
     * @return distance in feet
     */
    protected int shortestPerimeter() {
        return dimensions.stream()
                .mapToInt(Dimension::getX)
                .sorted()
                .limit(2)
                .reduce(0, (total, x) -> total + 2 * x);
    }
}
