package ch.two;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    static void task4(String[] path){
        //2.5.28
        String directoryPath = Arrays.toString(path);

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directoryPath);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Unable to read files from directory: " + directoryPath);
            return;
        }

        Arrays.sort(files);

        System.out.println("Files in directory " + directoryPath + ", sorted alphabetically:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
