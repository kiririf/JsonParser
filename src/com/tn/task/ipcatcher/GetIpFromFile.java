package com.tn.task.ipcatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetIpFromFile implements GetIpFrom {
    @Override
    public String ipFromAnywhere(String jsonInputFile) {
        String targetIp = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(jsonInputFile))) {
            targetIp = reader.readLine();
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных из файла:" + e.getMessage());
            e.printStackTrace();
        }

        return targetIp;
    }
}
