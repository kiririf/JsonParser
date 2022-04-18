package com.tn.task.variableinput;

import com.tn.task.ipcatcher.GetIpFromFile;
import com.tn.task.ipcatcher.JsonGetter;

import static com.tn.task.ipwriter.IpWriteInFile.ipInFile;

public class InputJsonFromFile implements VariableInput{
    public static final String DEFAULT_JSON_INPUT_FILE = "jsonInputFile.txt";
    @Override
    public void jsonInputStream(String[] args) {
        if (args.length > 0 && args[0].equals("file")) {
            String jsonInputFile = args.length > 1 ? args[1] : DEFAULT_JSON_INPUT_FILE;
            ipInFile(JsonGetter.takeIp(new GetIpFromFile(), jsonInputFile));
        } else {
            new InputJson().jsonInput(new InputJsonFromUrl(), args);
        }
    }
}
