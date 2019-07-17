package nsu.manasyan.linesort.filehandlers;

import nsu.manasyan.linesort.sorter.Sorter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class StringFileHandler extends FileHandler{
    private Comparator<String>  comparator;

    public StringFileHandler(Path filePath, String outFilePrefix, Sorter sorter, Comparator<String> comparator) {
        super(filePath,outFilePrefix,sorter);
        this.comparator = comparator;
    }

    @Override
    public void run() {
        try{ List<String> strings = Files.readAllLines(getFilePath());
            getSorter().sort(strings,comparator);
            Files.write(getOutFilePath(),strings);
        }  catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
