package com.tn.task.ipcatcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.task.neededclass.IP;
import org.jsoup.Jsoup;

import java.io.FileReader;
import java.io.IOException;

public class GetIpFrom {

    public static IP ipGetFromUrl(String urlWhereJson) {
        String ipReader = null;

        try {
            ipReader = Jsoup.connect(urlWhereJson)
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных по URL:" + e.getMessage());
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(ipReader, IP.class);//переводим Json в объект
    }


    public static IP ipGetFromFile(String fileWhereJson) {
        String newIp = null;

        try (FileReader ipReader = new FileReader(fileWhereJson)){
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
