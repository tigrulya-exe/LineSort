package nsu.manasyan.linesort.filehandlers;

import java.nio.file.Path;
import java.util.Comparator;

public class IntegerFileHandler extends FileHandler {

    public IntegerFileHandler(Path filePath, String outFilePrefix, Comparator<String> comparator) {
        super(filePath,outFilePrefix);
    }

    @Override
    public void run() {

    }
}
