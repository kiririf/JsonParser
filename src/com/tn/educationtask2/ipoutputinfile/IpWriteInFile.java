package com.tn.educationtask2.ipoutputinfile;

import com.tn.educationtask2.neededclass.IP;

import java.io.FileWriter;
import java.io.IOException;

public class IpWriteInFile {
    public static void writeToFile(IP userIp) {
        try (FileWriter writeIp = new FileWriter("ipBarn.txt")) {//отлавливаем исключения
            writeIp.write("ip ползователя:" + userIp.getIp());
        } catch (IOException ioException) {
            System.out.print("Возникли проблемы с записью данных в файл:" + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            System.out.println("unable to get json from provided path");
        }
    }
}
