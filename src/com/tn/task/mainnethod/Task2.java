package com.tn.task.mainnethod;

import com.tn.task.variableinput.InputJson;
import com.tn.task.variableinput.InputJsonFromFile;

public class Task2 {

    public static void main(String[] args) {
        new InputJson().jsonInput(new InputJsonFromFile(), args);
    }
}
