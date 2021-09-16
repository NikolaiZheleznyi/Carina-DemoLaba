package com.qaprosoft.carina.demo.gui.components.kufar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileReadSparesKufar {
    private final List<String> lineList;

    private void readFile() {
        String fileName = "/Users/nzheleznui/SOLVD/carina/src/main/java/com/qaprosoft/carina/demo/gui/components/kufar/sparesKufarFile";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null){
                lineList.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileReadSparesKufar(){
        lineList = new LinkedList<>();
        readFile();
    }

    public List<String> getLineList() {
        return lineList;
    }

}
