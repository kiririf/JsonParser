package com.tn.educationtask2.takesipfromanywhere;

import org.jsoup.Jsoup;

import java.io.IOException;

public class GetIpFromUrl implements GetIpStrategy {
    public static final String DEFAULT_JSON_INPUT_URL = "https://api.ipify.org/?format=json";

    @Override
    public String ipFromStrategy(String userInputUrl) {
        String inputPath = userInputUrl != null ? userInputUrl : DEFAULT_JSON_INPUT_URL;

        String targetIp = null;
        try {
            targetIp = Jsoup.connect(inputPath)
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IllegalArgumentException argumentException) {
            System.out.println("non-existent link entered, exception message:" +
                    argumentException.getMessage());
        } catch (IOException ioException) {
            System.out.println("Something went wrong while trying to connect using the link, exception message:" +
                    ioException.getMessage());
        }

        return targetIp;
    }
}
