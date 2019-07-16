package nsu.manasyan.linesort.sorter;

import java.util.Comparator;
import java.util.List;

public interface Sorter {
    <T> void sort(List<T> values, Comparator<T> comparator);
}
