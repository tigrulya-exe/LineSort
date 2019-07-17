package nsu.manasyan.linesort;

import nsu.manasyan.linesort.arguments.ArgumentsResolver;
import nsu.manasyan.linesort.exceptions.LineSortException;

public class Main {

    public static void main(String[] args) {
        try {
            var arguments = ArgumentsResolver.resolve(args);
            FileLineSortingService sortingService = new FileLineSortingService();
            sortingService.start(arguments.getDirectoryPath(), arguments.getOutPrefix(), arguments.getContentType(), arguments.getSortMode());
        } catch (LineSortException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
