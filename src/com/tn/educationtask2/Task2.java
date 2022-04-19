package com.tn.educationtask2;

import com.tn.educationtask2.takesipfromanywhere.GetIpStrategy;
import com.tn.educationtask2.takesipfromanywhere.JsonToIPParser;
import com.tn.educationtask2.variationsinput.StrategyTypeEnum;

import static com.tn.educationtask2.ipoutputinfile.IpWriteInFile.ipInFile;

public class Task2 {

    public static void main(String[] args) {

        if (args.length > 0) {
            String inputType = args[0];
            String userInputPath = args.length > 1 ? args[1] : null;
            GetIpStrategy strategyType = null;
            try {
                strategyType = StrategyTypeEnum.valueOf(inputType.toUpperCase()).chosenPath();
            } catch (RuntimeException e) {
                System.out.println("Enter the correct input type");
            }
            JsonToIPParser jsonToIpObject = new JsonToIPParser();
            jsonToIpObject.setGetIpFrom(strategyType);
            ipInFile(jsonToIpObject.handleIp(userInputPath));

        } else {
            throw new RuntimeException("Enter at least one argument");
        }
    }
}
