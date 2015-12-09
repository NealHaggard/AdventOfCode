package com.santa.day2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for presents.
 *
 * @author Neal Haggard
 */
public class PresentTest {
    private Present presentA;
    private Present presentB;

    @Before
    public void setup() {
        presentA = new Present("2x3x4");
        presentB = new Present("1x1x10");
    }

    @Test
    public void should_calculate_wrapping_paper_needed_for_2x3x4() {
        assertEquals(58, presentA.wrappingPaperNeeded());
    }

    @Test
    public void should_calculate_wrapping_paper_needed_for_1x1x10() {
        assertEquals(43, presentB.wrappingPaperNeeded());
    }

    @Test
    public void should_calculate_volume_for_2x3x4() {
        assertEquals(24, presentA.volume());
    }

    @Test
    public void should_calculate_volume_for_1x1x10() {
        assertEquals(10, presentB.volume());
    }

    @Test
    public void should_calculate_shortest_perimeter_for_2x3x4() {
        assertEquals(10, presentA.shortestPerimeter());
    }

    @Test
    public void should_calculate_shortest_perimeter_for_1x1x10() {
        assertEquals(4, presentB.shortestPerimeter());
    }

    @Test
    public void should_calculate_needed_ribbon_for_2x3x4() {
        assertEquals(34, presentA.ribbonNeeded());
    }

    @Test
    public void should_calculate_needed_ribbon_for_1x1x10() {
        assertEquals(14, presentB.ribbonNeeded());
    }
}