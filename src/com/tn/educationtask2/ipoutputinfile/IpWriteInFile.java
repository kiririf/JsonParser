package com.tn.educationtask2.ipoutputinfile;

import com.tn.educationtask2.neededclass.IP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.newBufferedWriter;

public class IpWriteInFile {
    public static final String NOT_FIND_MESSAGE = "unable to get json from provided path";

    public static void writeToFile(IP userIp) {
        String outputMessage = userIpValid(userIp);

        try (BufferedWriter writeIp = newBufferedWriter(Paths.get("ipBarn.txt"))) {
            writeIp.write("user ip:" + outputMessage);
        } catch (IOException ioException) {
            System.out.println(NOT_FIND_MESSAGE);
        }
    }

    private static String userIpValid(IP userIp) {
        if(userIp != null) {
            return userIp.getIp();
        } else {
            return NOT_FIND_MESSAGE;
        }
    }
}
