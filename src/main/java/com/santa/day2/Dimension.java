package com.santa.day2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Helper to hold onto dimensions of a side of a package.
 *
 * @author Neal Haggard
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Dimension {
    private Integer x;

    private Integer y;

    public int area() {
        return x * y;
    }
}
