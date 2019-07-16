package nsu.manasyan.linesort.filehandlers;

import nsu.manasyan.linesort.exceptions.WrongFileTypeException;
import nsu.manasyan.linesort.sorter.InsertionSorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerFileHandler extends FileHandler {
    private Comparator<Integer> comparator;

    public IntegerFileHandler(Path filePath, String outFilePrefix, Comparator<Integer> comparator) {
        super(filePath,outFilePrefix);
        this.comparator = comparator;
    }

    @Override
    public void run() {
        InsertionSorter sorter = new InsertionSorter();

        try{ List<String> strings = Files.readAllLines(getFilePath());
            List<Integer> values = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
            sorter.sort(values,comparator);
            Files.write(getOutFileName(),getOutLines(values));

        }  catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe){
            throw new WrongFileTypeException("Wrong file type");
        }
    }

    private List<String> getOutLines(List<Integer> values){
        return values.stream().map(String::valueOf).collect(Collectors.toList());
    }
}
