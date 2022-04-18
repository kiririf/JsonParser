package com.tn.task.ipcatcher;

import org.jsoup.Jsoup;

import java.io.IOException;

public class GetIpFromUrl implements GetIpFrom {
    @Override
    public String ipFromAnywhere(String jsonInputUrl) {
        String targetIp = null;

        try {
            targetIp = Jsoup.connect(jsonInputUrl)
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IOException e) {
            System.out.println("Возникли проблемы с получением данных по URL:" + e.getMessage());
            e.printStackTrace();
        }

        return targetIp;
    }
}
