    package nsu.manasyan.linesort;


import nsu.manasyan.linesort.arguments.ArgumentsResolver;

import java.io.IOException;

    public class Main {
    private static String testDirectoryPath = "C:/Users/Tigrulya/Desktop/thr demo/lineSort/testFiles";

    public static void main(String[] args) {
        var arguments = ArgumentsResolver.checkArgs(args);
        FileLineSortingService sortingService = new FileLineSortingService();
        try { sortingService.start(arguments.getDirectoryPath(), arguments.getOutPrefix(), arguments.getContentType(), arguments.getSortMode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
