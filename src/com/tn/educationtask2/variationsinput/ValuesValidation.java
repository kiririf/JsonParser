package com.tn.educationtask2.variationsinput;

import com.tn.educationtask2.neededclass.IP;

import static com.tn.educationtask2.Task2.RUNTIME_DESCRIPTION;
import static com.tn.educationtask2.ipoutputinfile.IpWriteInFile.NOT_FIND_MESSAGE;

public class ValuesValidation {
    public static boolean argsValidation(String[] args) {
        boolean validType = args.length > 0;
        if (!validType) throw new RuntimeException(RUNTIME_DESCRIPTION);
        return args.length > 1;
    }

    public static String validInputPath(String userInput, String defaultMessage) {
        return userInput != null ? userInput : defaultMessage;
    }


    public static String userIpValid(IP userIp) {
        if(userIp != null) {
            return userIp.getIp();
        } else {
            return NOT_FIND_MESSAGE;
        }
    }
}
