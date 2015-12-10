package com.santa.day3;

import com.santa.elves.FileHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests for PresentDeliveryParser.
 *
 * @author Neal Haggard
 */
public class PresentDeliveryParserTest {

    private PresentDeliveryParser parser;

    @Before
    public void before_each() {
        parser = new PresentDeliveryParser();
    }

    @Test
    public void verify_example_1() {
        assertEquals(2, parser.deliver(0, 0, "^"));
    }

    @Test
    public void verify_example_2() {
        assertEquals(4, parser.deliver(0, 0, "^>v<"));
    }

    @Test
    public void verify_example_3() {
        assertEquals(2, parser.deliver(0, 0, "^v^v^v^v^v"));
    }

    @Test
    public void verify_part1() throws IOException {
        assertEquals(2565, FileHelper.readLines("src/test/java/com/santa/day3/puzzleInput.txt")
                .mapToInt(directions -> parser.deliver(0, 0, directions)).sum());
    }
}