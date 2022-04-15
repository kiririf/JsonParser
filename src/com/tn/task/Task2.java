package com.tn.task;

import com.tn.task.ipwriter.IpWriteInFile;

public class Task2 {
    public static void main(String[] args) {
        IpWriteInFile writer = new IpWriteInFile();
        writer.ipInFile(args);
    }
}
