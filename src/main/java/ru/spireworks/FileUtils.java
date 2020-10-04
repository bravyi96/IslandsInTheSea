package ru.spireworks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static final String INPUT_FILE_PATH = "src/main/resources/input-data.txt";
    private static List<String> dataList;

    public static List<String> readFileToList() {
        try (Scanner scanner = new Scanner(new File(INPUT_FILE_PATH))) {
            dataList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                dataList.add(scanner.nextLine().replaceAll("\\s", ""));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return dataList;
    }
}