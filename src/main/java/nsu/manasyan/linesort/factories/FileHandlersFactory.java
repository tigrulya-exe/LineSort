package nsu.manasyan.linesort.factories;

import nsu.manasyan.linesort.exceptions.WrongArgumentException;
import nsu.manasyan.linesort.filehandlers.FileHandler;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class FileHandlersFactory {

    private static Map<String, FileHandlerCreator> fileHandlers;

    static {
        fileHandlers = new HashMap<>();
        fileHandlers.put("s", new StringFileHandlerCreator());
        fileHandlers.put("i", new IntegerFileHandlerCreator());
    }

    private static FileHandlersFactory instance;

    private FileHandlersFactory(){}

    public static FileHandlersFactory getInstance(){
        if(instance == null)
            instance = new FileHandlersFactory();

        return instance;
    }

    public FileHandler getFileHandler(String key, Path filePath, String outFilePrefix, Comparator<String> comparator){
        var fileHandlerCreator =  fileHandlers.get(key);
        if(fileHandlerCreator == null)
            throw new WrongArgumentException("Wrong content type");
        return fileHandlerCreator.create(filePath,outFilePrefix,comparator);
    }

}
