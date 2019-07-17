package nsu.manasyan.linesort.arguments;

import java.util.List;

public class CommandLineOptions {
    private CommandLineOptionsData optionsData;

    private String directoryPath;

    public CommandLineOptions(CommandLineOptionsData commandLineOptionsData){
        this.optionsData = commandLineOptionsData;
    }

    public String getOutPrefix(){
        return optionsData.outPrefix;
    }

    public String getContentType(){
        return optionsData.contentType;
    }

    public String getSortMode(){
        return optionsData.sortMode;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public List<String> getOptions(){
        return List.of(optionsData.outPrefix, optionsData.contentType, optionsData.sortMode);
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }
}
