package com.tn.task;

import com.tn.task.ipcatcher.IpFromUrl;
import com.tn.task.ipwriter.IpWriteInFile;
public class Task2 {
    public static void main(String[] args) {
        IpFromUrl catcher = new IpFromUrl();
        IpWriteInFile writer = new IpWriteInFile();
        writer.ipInFile(catcher.ipSetFromUrl());
    }
}
