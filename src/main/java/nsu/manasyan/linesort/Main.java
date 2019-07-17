    package nsu.manasyan.linesort;


import nsu.manasyan.linesort.arguments.ArgumentsResolver;
import nsu.manasyan.linesort.exceptions.LineSortException;


    public class Main {
    private static String testDirectoryPath = "C:/Users/Tigrulya/Desktop/thr demo/lineSort/testFiles";

    public static void main(String[] args) {
        var arguments = ArgumentsResolver.resolve(args);

        try {
            FileLineSortingService sortingService = new FileLineSortingService();
            sortingService.start(arguments.getDirectoryPath(), arguments.getOutPrefix(), arguments.getContentType(), arguments.getSortMode());
        } catch (LineSortException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
