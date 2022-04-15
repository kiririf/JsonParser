package com.tn.task.ipwriter;

import com.tn.task.ipcatcher.IpGet;
import com.tn.task.neededclass.IP;

import java.io.FileWriter;
import java.io.IOException;

public class IpWriteInFile implements IpGet.jsonGet {
    public void ipInFile(String[] args){
        IP userIp = ipFromUrlOrFile(args);

        try (FileWriter writeIp = new FileWriter("ipBarn.txt")) {//отлавливаем исключения
            writeIp.write("ip ползователя:" + userIp.getIp());
        } catch (IOException e) {
            System.out.print("Возникли проблемы с записью данных в файл:" + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public IP ipFromUrlOrFile(String[] args) {
        return IpGet.jsonGet.super.ipFromUrlOrFile(args);
    }

    @Override
    public IP ipGetFromFile(String fileWhereJson) {
        return IpGet.jsonGet.super.ipGetFromFile(fileWhereJson);
    }

    @Override
    public IP ipGetFromUrl(String urlWhereJson) {
        return IpGet.jsonGet.super.ipGetFromUrl(urlWhereJson);
    }
}
