package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Island {
    private int size;
    private List<int[]> hCoords;
    private List<int[]> vCoords;

    public Island() {
        size = 0;
        hCoords = new ArrayList<>();
        vCoords = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append("\n");
        for (int i = 0; i < size; i++) {
            string.append(Arrays.toString(hCoords.get(i))).append(" ");
            string.append(Arrays.toString(vCoords.get(i))).append("\n");
        }

        return string.toString();
    }
}
