package com.santa.day2;

import lombok.Getter;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.stream;

/**
 * A present, a perfect rectangular cube.
 *
 * @author Neal Haggard
 */
@Getter
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
}
