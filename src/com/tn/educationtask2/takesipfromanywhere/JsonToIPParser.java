package com.tn.educationtask2.takesipfromanywhere;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tn.educationtask2.ipoutputinfile.IpWriteInFile;
import com.tn.educationtask2.neededclass.IP;
import lombok.Setter;

public class JsonToIPParser extends IpWriteInFile {
    @Setter
    GetIpStrategy getIpStrategy;

    public final IP transformationToIp(String userInputPath) {
        String targetIp = null;
        try {
            targetIp = getIpStrategy.ipFromStrategy(userInputPath);
        } catch (NullPointerException exception) {
            System.out.println("Please, input correct type");
        }
        GsonBuilder builder = new GsonBuilder();
        Gson parser = builder.create();//создаём парсер, который преобразует Json в объект
        return parser.fromJson(targetIp, IP.class);//переводим Json в объект
    }
}
