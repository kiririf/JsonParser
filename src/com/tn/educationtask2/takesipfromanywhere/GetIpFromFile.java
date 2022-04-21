package com.tn.educationtask2.takesipfromanywhere;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.tn.educationtask2.variationsinput.ValuesValidation.validInputPath;

public class GetIpFromFile implements GetIpStrategy {
    public static final String DEFAULT_JSON_INPUT_FILE = "jsonInputFile.txt";
    public static final String LOG_MESSAGE = "entered non-existent file, exception message:";

    @Override
    public String getIpStrategy(String userInput) {
        String inputPath = validInputPath(userInput, DEFAULT_JSON_INPUT_FILE);

        String targetIp = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            targetIp = reader.readLine();
        } catch (IOException e) {
            System.out.println(LOG_MESSAGE + e.getMessage());
        }

        return targetIp;
    }
}
