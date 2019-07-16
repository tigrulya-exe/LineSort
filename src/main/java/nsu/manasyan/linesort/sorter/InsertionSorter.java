package nsu.manasyan.linesort.sorter;

import nsu.manasyan.linesort.sorter.Sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertionSorter implements Sorter {

    public <T> void sort(List<T> values, Comparator<T> comparator){
        for(int i = 1; i < values.size(); ++i){
            for(int j = i; j > 0 && comparator.compare(values.get(j-1), values.get(j)) > 0; --j){
                Collections.swap(values,j-1,j);
            }
        }
    }
}
