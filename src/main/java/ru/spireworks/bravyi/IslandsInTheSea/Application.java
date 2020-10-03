package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

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
            System.out.println(island.toString());
//            List<String> map = new ArrayList<>();
//
//            for (int i = 0; i < island.getSize(); i++) {
//                for (int j = 0 ; j < island.getSize(); j++) {
//
//                }
//            }
        }
    }

    public static void main( String[] args ) {
        Application application = new Application();
        application.setIslandUtils(new IslandUtils());
        application.start();
    }
}
