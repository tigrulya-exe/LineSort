package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.filehandlers.FileHandler;

import java.nio.file.Path;
import java.util.Comparator;

@FunctionalInterface
public interface FileHandlerCreator<T> {
    FileHandler create (Path filePath, String outFilePrefix, Comparator<T> comparator);
}
