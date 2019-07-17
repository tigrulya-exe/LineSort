package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.filehandlers.FileHandler;
import nsu.manasyan.linesort.filehandlers.StringFileHandler;
import nsu.manasyan.linesort.sorter.InsertionSorter;

import java.nio.file.Path;
import java.util.Comparator;

public class StringFileHandlerCreator implements FileHandlerCreator<String> {
    @Override
    public FileHandler create(Path filePath, String outFilePrefix, Comparator<String> comparator) {
        return new StringFileHandler(filePath,outFilePrefix, new InsertionSorter(),comparator);
    }
}
