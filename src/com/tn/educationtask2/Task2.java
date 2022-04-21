package com.tn.educationtask2;

import com.tn.educationtask2.takesipfromanywhere.JsonToIPParser;
import com.tn.educationtask2.variationsinput.StrategyTypeEnum;

import java.util.Optional;

import static com.tn.educationtask2.ipoutputinfile.IpWriteInFile.writeToFile;
import static com.tn.educationtask2.variationsinput.ValuesValidation.argsValidation;

public class Task2 {
    public static final String RUNTIME_DESCRIPTION = "enter at least one argument: file, url";

    public static void main(String[] args) {
        boolean userPathExist = argsValidation(args);
        String inputType = args[0];

        Optional<StrategyTypeEnum> strategyByName = StrategyTypeEnum.getValueByName(inputType);
        if (strategyByName.isEmpty()) {
            System.out.println(RUNTIME_DESCRIPTION);
            return;
        }

        String userInputPath = userPathExist ? args[1] : null;
        JsonToIPParser jsonToIp = new JsonToIPParser();
        jsonToIp.setGetIpStrategy(strategyByName.get().usedStrategy());
        writeToFile(jsonToIp.transformToIp(userInputPath));
    }
}
