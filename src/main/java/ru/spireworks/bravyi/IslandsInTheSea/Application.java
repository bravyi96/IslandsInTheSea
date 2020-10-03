package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Application {
    private static final String FILE_PATH = "input_data.txt";

    private IslandUtils islandUtils;

    private void start() {
        List<String> data = islandUtils.readFile(FILE_PATH);
        List<Island> islands = islandUtils.getAllIslands(data);

        List<String> map = new ArrayList<>();
        for (Island island : islands) {
            System.out.println(island.toString());

            for (int i = 0; i < island.getSize(); i++) {
                generateMap(map, island.getHCoords().get(i), island.getVCoords().get(i));
            }
        }

        for (String str : map) {
            System.out.println(str);
        }
    }

    private void generateMap(List<String> map, int[] hor, int[] ver) {

    }

    public static void main( String[] args ) {
        Application application = new Application();
        application.setIslandUtils(new IslandUtils());
        application.start();
    }
}
