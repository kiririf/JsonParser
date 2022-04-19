package com.tn.educationtask2.ipoutputinfile;

import com.tn.educationtask2.neededclass.IP;

import java.io.FileWriter;
import java.io.IOException;

public class IpWriteInFile {
    public static void writeToFile(IP userIp) {
        try (FileWriter writeIp = new FileWriter("ipBarn.txt")) {//отлавливаем исключения
            writeIp.write("user ip:" + userIp.getIp());
        } catch (IOException ioException) {
            System.out.print("unable to write data to file:" + ioException.getMessage());
            ioException.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            System.out.println("unable to get json from provided path");
        }
    }
}
