import java.util.List;

/**
 * Represents strategy for sorting collection entries
 */
public interface CardSortStrategy {
    /**
     * Returns sorted copy of given collection entries
     *
     * @param entries the collection entries to be sorted
     * @return the sorted collection entries
     */
    List<CollectionEntry> sort(List<CollectionEntry> entries);
}