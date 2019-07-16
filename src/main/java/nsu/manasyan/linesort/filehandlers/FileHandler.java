package nsu.manasyan.linesort.filehandlers;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileHandler implements Runnable {
    private Path filePath;
    private Path outFileName;

    private Path constructOutFileName(String  outFilePrefix){
        String parent = filePath.getParent().toString();
        String outFileName = parent + "/" + outFilePrefix + filePath.getFileName();

        return Paths.get(outFileName);
    }

    public FileHandler(Path filePath, String outFilePrefix) {
        this.filePath = filePath;
        this.outFileName = constructOutFileName(outFilePrefix);
    }

    public Path getFilePath() {
        return filePath;
    }

    public Path getOutFileName() {
        return outFileName;
    }
}
