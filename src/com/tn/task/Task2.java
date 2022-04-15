package com.tn.task;

import com.tn.task.ipcatcher.GetIpFromFile;
import com.tn.task.ipcatcher.GetIpFromUrl;
import com.tn.task.ipcatcher.JsonGetter;
import com.tn.task.ipwriter.IpWriteInFile;

public class Task2 {
    public static final String DEFAULTURL = "https://api.ipify.org/?format=json";
    public static final String DEFAULTFILE = "jsonhere.txt";

    public static void main(String[] args) {
        IpWriteInFile writer = new IpWriteInFile();

        if (args.length > 0 && args[0].equals("file")) {
            String urlWhereJson = args.length == 2 ? args[1] : DEFAULTFILE;
            writer.ipInFile(JsonGetter.takeIp(new GetIpFromFile(), urlWhereJson));
        } else {
            String fileWhereJson = args.length == 2 ? args[1] : DEFAULTURL;
            writer.ipInFile(JsonGetter.takeIp(new GetIpFromUrl(), fileWhereJson));
        }
    }
}
