package ru.spireworks;

import lombok.Getter;

import java.util.List;

public class Map {
    private int size;
    @Getter
    private final int[][] inputVerticalDataFile;
    @Getter
    private final int[][] inputHorizontalDataFile;
    @Getter
    private final char[][] verticalArray;
    @Getter
    private final char[][] horizontalArray;
    @Getter
    private final char[][] outputArray;

    private static int indexBeginningNextMap = 0;

    public Map(List<String> dataList) {
        if (indexBeginningNextMap == 0) {
            size = Integer.parseInt(dataList.get(0));
            indexBeginningNextMap = 1;
        } else if (dataList.get(indexBeginningNextMap).isEmpty()) {
            size = Integer.parseInt(dataList.get(++indexBeginningNextMap));
            indexBeginningNextMap++;
        }

        //Создаем из файла массив числел
        inputHorizontalDataFile = listParserToArray(size, dataList);
        inputVerticalDataFile = listParserToArray(size, dataList);

        //Преобразуем массив чисел в массив символов
        verticalArray = createCharArray(inputVerticalDataFile);
        horizontalArray = createCharArray(inputHorizontalDataFile);
        outputArray = createOutputArray();
    }

    private int[][] listParserToArray(int size, List<String> list) {
        int[][] result = new int[size][size];
        for (int i = indexBeginningNextMap; i < size + indexBeginningNextMap; i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                result[i - indexBeginningNextMap][j] = Integer.parseInt(String.valueOf(list.get(i).charAt(j)));
            }
        }
        indexBeginningNextMap += size;

        return result;
    }

    private char[][] createCharArray(int[][] array) {
        StringBuilder sb;
        char[][] result = new char[size][size];
        for (int i = 0; i < size; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < array[i][j]; k++) {
                    sb.append("*");
                }
                if (sb.length() != size)
                    sb.append("_");
            }
            result[i] = sb.toString().toCharArray();
        }

        return result;
    }

    private char[][] createOutputArray() {
        char[][] hor = horizontalArray.clone();
        char[][] ver = reverseArray(verticalArray);
        int[] countHorRow = new int[size];
        int[] countVerRow = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (hor[i][j] == '*') {
                    countHorRow[i]++;
                }
                if (ver[i][j] == '*') {
                    countVerRow[i]++;
                }
            }
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (countHorRow[i] == countVerRow[j]){
                    hor[i] = ver[j];
                }
            }
        }

        return hor;
    }

    public char[][] reverseArray(char[][] array) {
        char[][] result = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = array[j][i];
            }
        }

        return result;
    }

    public char[] moveElementInRow(char[] rowArray) {
        for (int i = rowArray.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (rowArray[j] != rowArray[i]) {
                    char temp = rowArray[i];
                    rowArray[i] = rowArray[j];
                    rowArray[j] = temp;
                } else {
                    break;
                }
            }
        }

        return rowArray;
    }

    private void createResult(StringBuilder result, int[][] array, char[][] chars , String name) {
        result.append("\n\t").append(name).append(":\n");

        for (int i = 0; i < array.length; i++) {
            result.append("\t\t");
            for (int j = 0; j < array[i].length; j++) {
                result.append(array[i][j]).append("\t");
            }
            for (int k = 0; k < chars[i].length; k++) {
                result.append(" ").append(chars[i][k]);
            }
            result.append("\n");
        }
    }

    private void createResult(StringBuilder result, char[][] chars) {
        result.append("\n\t").append("OutputData").append(":\n");

        for (char[] aChar : chars) {
            result.append("\t\t");
            for (char c : aChar) {
                result.append(" ").append(c);
            }
            result.append("\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Map size = ").append(size);

        createResult(result, inputHorizontalDataFile, horizontalArray, "HorizontalData");
        createResult(result, inputVerticalDataFile, verticalArray, "VerticalData");
        createResult(result, outputArray);

        return result.toString();
    }
}
