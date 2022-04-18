package com.tn.task.ipcatcher;

import java.io.FileReader;
import java.io.IOException;

public class GetIpFromFile implements GetIpFrom {
    @Override
    public String ipFromAnywhere(String jsonInputFile) {
        String newIp = null;

        try (FileReader ipReader = new FileReader(jsonInputFile)) {
            newIp = String.valueOf(ipReader.read());
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных из файла:" + e.getMessage());
            e.printStackTrace();
        }

        return newIp;
    }
}
