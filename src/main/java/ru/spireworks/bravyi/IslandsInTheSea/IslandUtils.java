package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IslandUtils {
    private static final Logger LOGGER = Logger.getLogger(IslandUtils.class);

    private static final String IS_NOT_NUMBER_ERROR = "Строка, %s не является числом. Построение  карты невозможно!";
    private static final String ZERO = "0";

    // Получаем все данные из файла построчно
    public List<String> readFile(final String filePath) {
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

    // Получаем все острова с координатами по горизонтали и по вертикали
    public List<Island> getAllIslands(List<String> coords) {
        List<Island> islands = new ArrayList<>();
        Island island = new Island();
        for (String line : coords) {
            if (StringUtils.isEmpty(line)) continue;
            line = StringUtils.deleteWhitespace(line);
            if(!NumberUtils.isDigits(line)) {
                LOGGER.error(String.format(IS_NOT_NUMBER_ERROR, line));
                return null;
            }

            if (checkEndOfLineForZero(line)) {
                char[] tempCoords = line.toCharArray();
                int[] islandCoords = new int[island.getSize()];

                for (int i = 0; i < island.getSize(); i++) {
                    if (i < tempCoords.length)
                        islandCoords[i] = Character.getNumericValue(tempCoords[i]);
                    else islandCoords[i] = 0;
                }

                if (island.getHCoords().size() < island.getSize()) {
                    island.getHCoords().add(islandCoords);
                } else if (island.getVCoords().size() < island.getSize()) {
                    island.getVCoords().add(islandCoords);
                }
            } else {
                if (island.getSize() != 0) islands.add(island);
                island = new Island();
                island.setSize(Integer.parseInt(line));
            }
        }
        islands.add(island);
        return islands;
    }

    // Проверка, что строка не пустая и заканчивается 0
    private boolean checkEndOfLineForZero(String line) {
        return StringUtils.isNotEmpty(line) && line.endsWith(ZERO);
    }
}
