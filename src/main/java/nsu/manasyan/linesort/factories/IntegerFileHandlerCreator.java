package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.filehandlers.FileHandler;
import nsu.manasyan.linesort.filehandlers.IntegerFileHandler;
import nsu.manasyan.linesort.sorter.InsertionSorter;

import java.nio.file.Path;
import java.util.Comparator;

public class IntegerFileHandlerCreator implements FileHandlerCreator<Integer> {
    @Override
    public FileHandler create(Path filePath, String outFilePrefix, Comparator<Integer> comparator) {
        return new IntegerFileHandler(filePath,outFilePrefix, new InsertionSorter(), comparator);
    }
}
