package com.tn.educationtask2.takesipfromanywhere;

import org.jsoup.Jsoup;

import java.io.IOException;

import static com.tn.educationtask2.variationsinput.ValuesValidation.validInputPath;

public class GetIpFromUrl implements GetIpStrategy {
    public static final String DEFAULT_JSON_INPUT_URL = "https://api.ipify.org/?format=json";
    public static final String ILLEGAL_ARG_MESSAGE = "non-existent link entered, exception message:";
    public static final String CONNECT_ERR_MESSAGE = "Can't connect with user link, exception message:";

    @Override
    public String getIpStrategy(String userInput) {
        String inputPath = validInputPath(userInput, DEFAULT_JSON_INPUT_URL);

        String targetIp = null;
        try {
            targetIp = Jsoup.connect(inputPath)
                    .ignoreContentType(true).execute().body();//подключаемся по ссылке и получаем данные
        } catch (IllegalArgumentException argumentException) {
            System.out.println(ILLEGAL_ARG_MESSAGE + argumentException.getMessage());
        } catch (IOException ioException) {
            System.out.println(CONNECT_ERR_MESSAGE + ioException.getMessage());
        }

        return targetIp;
    }
}
