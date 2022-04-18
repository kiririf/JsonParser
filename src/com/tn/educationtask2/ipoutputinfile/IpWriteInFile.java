package com.tn.educationtask2.ipoutputinfile;

import com.tn.educationtask2.neededclass.IP;

import java.io.FileWriter;
import java.io.IOException;

public class IpWriteInFile {
    public static void ipInFile(IP userIp) {
        try (FileWriter writeIp = new FileWriter("ipBarn.txt")) {//отлавливаем исключения
            writeIp.write("ip ползователя:" + userIp.getIp());
        } catch (IOException e) {
            System.out.print("Возникли проблемы с записью данных в файл:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
