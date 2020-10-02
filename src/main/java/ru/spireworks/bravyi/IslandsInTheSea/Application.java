package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.List;

@Getter
@Setter
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);
    private static final String FILE_PATH = "input_data.txt";
    private IslandTools islandTools;

    private void start() {
        List<String> data = islandTools.readFile(FILE_PATH);
        List<Island> islands = islandTools.getAllIslands(data);

        for (Island island : islands) {
            LOGGER.info("Размер острова: " + island.getSize());
            LOGGER.info("Координаты по горизонтали: " + island.getHCoords());
            LOGGER.info("Координаты по вертикали: " + island.getVCoords());
        }
    }

    public static void main( String[] args ) {
        Application application = new Application();
        application.setIslandTools(new IslandTools());
        application.start();
    }
}
