package org.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Utilities {

    private Utilities() {}

    public static void getDataFromFile(FileReader fileReader, String fileName) throws IOException {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                fileReader.read(input);
            }
        }
    }
}
