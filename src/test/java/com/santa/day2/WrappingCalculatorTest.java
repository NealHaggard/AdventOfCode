package com.santa.day2;

import com.santa.elves.FileHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Wrapping Calculator
 *
 * @author Neal Haggard (nehagg)
 * @since 4.17
 */
public class WrappingCalculatorTest {
    private static String[] PRESENTS = new String[]{"2x3x4", "1x1x10"};

    private String[] testInput;

    @Before
    public void setup() throws Exception {
        testInput = FileHelper.readLines("src/test/java/com/santa/day2/puzzleInput.txt");
    }

    @Test
    public void should_calculate_wrapping_paper_for_two() {
        assertEquals(101, WrappingCalculator.calculateTotalWrappingPaperArea(PRESENTS));
    }

    @Test
    public void verify_day2_part1() {
        assertEquals(1606483, WrappingCalculator.calculateTotalWrappingPaperArea(testInput));
    }

    @Test
    public void should_calculate_ribbon_for_two() {
        assertEquals(48, WrappingCalculator.calculateTotalRibbonLength(PRESENTS));
    }

    @Test
    public void verify_day2_part2() {
        assertEquals(3842356, WrappingCalculator.calculateTotalRibbonLength(testInput));
    }
}