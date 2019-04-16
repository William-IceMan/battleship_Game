package com.thoughtworks.game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFileUtils {

    public static List<String> readFile(String fileName) {

        List<String> input = new ArrayList<String>();

        //Get file from resources folder
        ClassLoader classLoader = ReadFileUtils.class.getClassLoader();
        if (classLoader.getResource(fileName) != null) {
            fileName = classLoader.getResource(fileName).getFile();
        }
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
