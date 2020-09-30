package ru.spireworks.bravyi.IslandsInTheSea;

import java.util.List;

public class Application {
    private static final String FILE_PATH = "input_data.txt";

    public static void main( String[] args ) {
        List<String> data = FileTools.readFile(FILE_PATH);

        for (String line : data) {
            System.out.println(line);
        }
    }
}
