package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Application {
    private static final Logger log = Logger.getLogger(Application.class);
    private static final String FILE_PATH = "input_data.txt";
    private IslandUtils islandUtils;

    private void start() {
        List<String> data = islandUtils.readFile(FILE_PATH);
        List<Island> islands = islandUtils.getAllIslands(data);

        for (Island island : islands) {
            List<String> map = new ArrayList<>();
            logging(island);

            for (int i = 0; i < island.getSize(); i++) {
                for (int j = 0 ; j < island.getSize(); j++) {

                }
            }
        }
    }

    private void logging(Island island) {
        log.info("Размер острова: " + island.getSize());
        log.info("Координаты по горизонтали: " + island.getHCoords());
        log.info("Координаты по вертикали: " + island.getVCoords() + "\n");
    }

    public static void main( String[] args ) {
        Application application = new Application();
        application.setIslandUtils(new IslandUtils());
        application.start();
    }
}
