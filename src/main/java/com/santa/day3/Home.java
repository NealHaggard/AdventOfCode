package com.santa.day3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents a home at a location in the infinite grid of Santa's delivery route.
 *
 * @author Neal Haggard
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Home {
    private final int x;
    private final int y;
}
