package com.tn.task.variableinput;

import com.tn.task.ipcatcher.GetIpFromUrl;
import com.tn.task.ipcatcher.JsonGetter;

import static com.tn.task.ipwriter.IpWriteInFile.ipInFile;

public class InputJsonFromUrl implements VariableInput{
    public static final String DEFAULT_JSON_INPUT_URL = "https://api.ipify.org/?format=json";

    @Override
    public void jsonInputStream(String[] args) {
        if (args.length > 0 && args[0].equals("url")) {
            String jsonInputUrl = args.length == 2 ? args[1] : DEFAULT_JSON_INPUT_URL;
            ipInFile(JsonGetter.takeIp(new GetIpFromUrl(), jsonInputUrl));
        } else {
            ipInFile(JsonGetter.takeIp(new GetIpFromUrl(), DEFAULT_JSON_INPUT_URL));
        }
    }
}
