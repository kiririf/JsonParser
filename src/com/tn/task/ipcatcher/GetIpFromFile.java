package com.tn.task.ipcatcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.task.neededclass.IP;

import java.io.FileReader;
import java.io.IOException;

public class GetIpFromFile implements GetIpFrom {
    @Override
    public IP ipFromAnywhere(String fileWhereJson) {
        String newIp = null;

        try (FileReader ipReader = new FileReader(fileWhereJson)) {
            newIp = String.valueOf(ipReader.read());
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных из файла:" + e.getMessage());
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(newIp, IP.class);//переводим Json в объект
    }
}
