package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.WrongArgumentException;
import nsu.manasyan.linesort.filehandlers.FileHandler;
import nsu.manasyan.linesort.filehandlers.IntegerFileHandler;
import nsu.manasyan.linesort.filehandlers.StringFileHandler;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FileHandlersFactory {

    private static Map<String, FileHandlerCreator> fileHandlers;

    static {
        fileHandlers = new HashMap<>();
        fileHandlers.put("i", IntegerFileHandler::new);
        fileHandlers.put("s", StringFileHandler::new);
    }

    private static FileHandlersFactory instance;

    private FileHandlersFactory(){}

    public static FileHandlersFactory getInstance(){
        if(instance == null)
            instance = new FileHandlersFactory();

        return instance;
    }

    public FileHandler getFileHandler(String key, Path filePath, String outFilePrefix, Comparator<String> comparator){
        var fileHandler =  fileHandlers.get(key);
        if(fileHandler == null)
            throw new WrongArgumentException("Wrong content type");
        return fileHandler.create(filePath,outFilePrefix,comparator);
    }

}
