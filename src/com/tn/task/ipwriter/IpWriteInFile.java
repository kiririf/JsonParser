package com.tn.task.ipwriter;

import com.tn.task.neededclass.IP;

import java.io.FileWriter;
import java.io.IOException;

public class IpWriteInFile {
    public void ipInFile(IP value){
        try (FileWriter writeIp = new FileWriter("ipBarn.txt")) {//отлавливаем исключения
            writeIp.write("ip ползователя:" + value.getIp());
        } catch (IOException e){
            System.out.print("Возникли проблемы с записью данных в файл:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
