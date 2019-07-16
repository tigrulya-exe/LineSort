package nsu.manasyan.linesort;

import nsu.manasyan.linesort.exceptions.WrongArgumentException;
import nsu.manasyan.linesort.factories.FileHandlersFactory;
import nsu.manasyan.linesort.filehandlers.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLineSortingService {

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private FileHandlersFactory factory = FileHandlersFactory.getInstance();


    public void start(String directoryPath, String outPrefix, String contentType, String sortMode) throws IOException {
        var files = extractFiles(directoryPath);
        files.forEach((f -> registerTask(f,outPrefix,contentType,sortMode)));
        executorService.shutdown();
    }

    private List<Path> extractFiles(String directoryPath) throws IOException{
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            return paths.filter(Files::isRegularFile).collect(Collectors.toList());
        }
    }

    private <T extends Comparable<? super T>> Comparator<T> getComparator(String sortMode){
        switch (sortMode){
            case "a" :
                return Comparator.naturalOrder();
            case "d":
                return Comparator.reverseOrder();
            default:
                throw new WrongArgumentException("Wrong sortMode");
        }
    }

    private void registerTask(Path filePath, String outPrefix, String contentType, String sortMode){
        FileHandler fileHandler = factory.getFileHandler(contentType,filePath,outPrefix, getComparator(sortMode));

        executorService.submit(fileHandler);
    }
}
