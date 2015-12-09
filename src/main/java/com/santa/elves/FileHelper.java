package com.santa.elves;

import lombok.Cleanup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Helper that reads from a file.
 *
 * @author Neal Haggard
 */
public class FileHelper {

    /**
     * Read lines from a file into a String[];
     *
     * @param filename Name of the file to load
     * @return Array of Strings
     * @throws IOException
     */
    public static Stream<String> readLines(String filename) throws IOException {
        @Cleanup
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        List<String> lines = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return lines.stream();
    }
}
