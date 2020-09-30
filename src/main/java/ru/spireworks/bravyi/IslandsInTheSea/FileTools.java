package ru.spireworks.bravyi.IslandsInTheSea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTools {
    public static List<String> readFile(final String filePath) {
        List<String> data = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(new File(filePath));
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                data.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
