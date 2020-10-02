package ru.spireworks.bravyi.IslandsInTheSea;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Island {
    private int size;
    private List<String> hCoords;
    private List<String> vCoords;

    public Island() {
        size = 0;
        hCoords = new ArrayList<>();
        vCoords = new ArrayList<>();
    }
}
