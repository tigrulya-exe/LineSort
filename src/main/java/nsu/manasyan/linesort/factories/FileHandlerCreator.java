package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.filehandlers.FileHandler;

import java.nio.file.Path;
import java.util.Comparator;

@FunctionalInterface
public interface FileHandlerCreator {
    FileHandler create (Path filePath, String outFilePrefix, Comparator<String> comparator);
}
