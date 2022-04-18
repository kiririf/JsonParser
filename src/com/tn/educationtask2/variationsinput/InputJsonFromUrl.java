package com.tn.educationtask2.variationsinput;

import com.tn.educationtask2.takesipfromanywhere.GetIpFromUrl;
import com.tn.educationtask2.takesipfromanywhere.JsonToIPParser;

import static com.tn.educationtask2.ipoutputinfile.IpWriteInFile.ipInFile;

public class InputJsonFromUrl implements VariableInput {
    public static final String DEFAULT_JSON_INPUT_URL = "https://api.ipify.org/?format=json";

    @Override
    public void jsonInputStream(String[] args) {
        if (args.length > 0 && args[0].equals("url")) {
            String jsonInputUrl = args.length > 1 ? args[1] : DEFAULT_JSON_INPUT_URL;
            ipInFile(JsonToIPParser.takeIp(new GetIpFromUrl(), jsonInputUrl));
        } else {
            ipInFile(JsonToIPParser.takeIp(new GetIpFromUrl(), DEFAULT_JSON_INPUT_URL));
        }
    }
}
