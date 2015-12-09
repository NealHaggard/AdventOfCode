package com.santa.day2;

import com.santa.elves.FileHelper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Wrapping Calculator
 *
 * @author Neal Haggard (nehagg)
 * @since 4.17
 */
public class WrappingCalculatorTest {

    @Test
    public void should_calculate_dimensions_for_2x3x4() {
        assertEquals(58, WrappingCalculator.calculateNeededWrappingPaper(new Present("2x3x4")));
    }

    @Test
    public void should_calculate_dimensions_for_1x1x10() {
        assertEquals(43, WrappingCalculator.calculateNeededWrappingPaper(new Present("1x1x10")));
    }

    @Test
    public void should_calculate_dimensions_for_both() {
        assertEquals(101, WrappingCalculator.calculateTotalWrappingPaperArea(new String[]{"2x3x4", "1x1x10"}));
    }

    @Test
    public void verify_day2_part1() throws Exception {
        assertEquals(1606483, WrappingCalculator.calculateTotalWrappingPaperArea(FileHelper.readLines("src/test/java/com/santa/day2/puzzleInput.txt")));
    }
}