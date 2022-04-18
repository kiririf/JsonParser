package com.tn.task.ipcatcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.task.neededclass.IP;

public class JsonGetter {
    GetIpFrom getIpFrom;

    public static IP takeIp(GetIpFrom getIpFrom, String jsonInputStream) {
        String targetIp = getIpFrom.ipFromAnywhere(jsonInputStream);
        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(targetIp, IP.class);//переводим Json в объект
    }
}
