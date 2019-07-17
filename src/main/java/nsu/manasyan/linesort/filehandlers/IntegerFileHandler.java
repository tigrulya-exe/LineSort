package nsu.manasyan.linesort.filehandlers;

import nsu.manasyan.linesort.sorter.Sorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerFileHandler extends FileHandler {
    private Comparator<Integer> comparator;

    public IntegerFileHandler(Path filePath, String outFilePrefix, Sorter sorter, Comparator<Integer> comparator) {
        super(filePath, outFilePrefix, sorter);
        this.comparator = comparator;
    }

    @Override
    public void run() {
        try{ List<String> strings = Files.readAllLines(getFilePath());
            List<Integer> values = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
            getSorter().sort(values,comparator);
            Files.write(getOutFilePath(),getOutLines(values));
        }  catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (NumberFormatException nfe){
            System.err.println(getFileTypeErrorMessage());
        }
    }

    private List<String> getOutLines(List<Integer> values){
        return values.stream().map(String::valueOf).collect(Collectors.toList());
    }
}