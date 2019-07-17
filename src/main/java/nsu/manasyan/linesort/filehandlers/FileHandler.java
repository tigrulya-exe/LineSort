package nsu.manasyan.linesort.filehandlers;

import nsu.manasyan.linesort.sorter.Sorter;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileHandler implements Runnable {
    private Path filePath;
    private Path outFileName;
    private Sorter sorter;

    private Path constructOutFileName(String  outFilePrefix){
        String parent = filePath.getParent().toString();
        String outFileName = parent + "/" + outFilePrefix + filePath.getFileName();

        return Paths.get(outFileName);
    }

    public FileHandler(Path filePath, String outFilePrefix, Sorter sorter) {
        this.filePath = filePath;
        this.outFileName = constructOutFileName(outFilePrefix);
        this.sorter = sorter;
    }

    public Path getFilePath() {
        return filePath;
    }

    public Path getOutFileName() {
        return outFileName;
    }

    protected String getFileTypeErrorMessage(){
        return "Wrong file type in: " + filePath;
    }

    public Sorter getSorter() {
        return sorter;
    }
}
