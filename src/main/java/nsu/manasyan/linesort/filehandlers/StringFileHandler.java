package nsu.manasyan.linesort.filehandlers;

import nsu.manasyan.linesort.sorter.InsertionSorter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class StringFileHandler extends FileHandler{
    private Comparator<String> comparator;

    public StringFileHandler(Path filePath, String outFilePrefix, Comparator<String> comparator) {
        super(filePath,outFilePrefix);
        this.comparator = comparator;
    }

    @Override
    public void run() {
        InsertionSorter sorter = new InsertionSorter();

        try{ List<String> strings = Files.readAllLines(getFilePath());
            sorter.sort(strings,comparator);
            Files.write(getOutFileName(),strings);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
