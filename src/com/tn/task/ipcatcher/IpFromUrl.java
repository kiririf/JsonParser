package com.tn.task.ipcatcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.task.neededclass.IP;
import org.jsoup.Jsoup;

import java.io.IOException;

public class IpFromUrl {
    public IP ipSetFromUrl(String url) {
        String ipReader = null;

        try {
            ipReader = Jsoup.connect(url)
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных по URL:" + e.getMessage());
            e.printStackTrace();
        }

        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(ipReader, IP.class);//переводим Json в объект
    }

    public IP ipSetFromUrl() {
        return ipSetFromUrl("https://api.ipify.org/?format=json");
    }
}
