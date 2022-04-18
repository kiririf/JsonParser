package com.tn.educationtask2.variationsinput;

import com.tn.educationtask2.takesipfromanywhere.GetIpFromFile;
import com.tn.educationtask2.takesipfromanywhere.JsonToIPParser;

import static com.tn.educationtask2.ipoutputinfile.IpWriteInFile.ipInFile;

public class InputJsonFromFile implements VariableInput {
    public static final String DEFAULT_JSON_INPUT_FILE = "jsonInputFile.txt";

    @Override
    public void jsonInputStream(String[] args) {
        if (args.length > 0 && args[0].equals("file")) {
            String jsonInputFile = args.length > 1 ? args[1] : DEFAULT_JSON_INPUT_FILE;
            ipInFile(JsonToIPParser.takeIp(new GetIpFromFile(), jsonInputFile));
        } else {
            new InputJson().jsonInput(new InputJsonFromUrl(), args);
        }
    }
}
