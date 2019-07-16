package nsu.manasyan.linesort;


import java.io.IOException;

public class Main {
    private static String directoryPath = "C:/Users/Tigrulya/Desktop/thr demo/lineSort/testFiles";


    public static void main(String[] args) {
        test();
    }

    private static void test(){
        FileLineSortingService sortingService = new FileLineSortingService();
        try {
            sortingService.start(directoryPath, "sort_", "i", "d");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
