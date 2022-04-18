package com.tn.educationtask2.takesipfromanywhere;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.educationtask2.neededclass.IP;

public class JsonToIPParser {
    GetIpFromAnywhere getIpFrom;

    public static IP takeIp(GetIpFromAnywhere getIpFrom, String jsonInputStream) {
        String targetIp = getIpFrom.ipFromAnywhere(jsonInputStream);
        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(targetIp, IP.class);//переводим Json в объект
    }
}
