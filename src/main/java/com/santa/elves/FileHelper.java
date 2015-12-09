package com.santa.elves;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
}
