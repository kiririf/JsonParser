package com.tn.educationtask2.mainmethod;

import com.tn.educationtask2.variationsinput.InputJson;
import com.tn.educationtask2.variationsinput.InputJsonFromFile;

public class Task2 {

    public static void main(String[] args) {
        new InputJson().jsonInput(new InputJsonFromFile(), args);
    }
}
