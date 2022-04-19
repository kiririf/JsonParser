package com.tn.educationtask2.takesipfromanywhere;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetIpFromFile implements GetIpStrategy {
    public static final String DEFAULT_JSON_INPUT_FILE = "jsonInputFile.txt";

    @Override
    public String getIpStrategy(String userInputFile) {
        String inputPath = userInputFile != null ? userInputFile : DEFAULT_JSON_INPUT_FILE;

        String targetIp = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            targetIp = reader.readLine();
        } catch (IOException e) {
            System.out.println("entered non-existent file, exception message:" +
                    e.getMessage());
        }

        return targetIp;
    }
}
