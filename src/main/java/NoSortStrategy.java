import java.util.ArrayList;
import java.util.List;

/**
 * Sorting strategy that doesn't change original order of collection
 */
public class NoSortStrategy implements CardSortStrategy {
    @Override
    public List<CollectionEntry> sort(List<CollectionEntry> entries) {
        return new ArrayList<>(entries);
    }
}