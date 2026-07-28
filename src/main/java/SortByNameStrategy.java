import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting strategy that orders collection entries by card name.
 * If 2 cards have the same name, they are ordered by set and then by grade.
 */
public class SortByNameStrategy implements CardSortStrategy {
    @Override
    public List<CollectionEntry> sort(List<CollectionEntry> entries) {
        List<CollectionEntry> sortedEntries = new ArrayList<>(entries);

        sortedEntries.sort(new Comparator<CollectionEntry>() {
            /**
             * Compares 2 collection entries by card name, then set, and then grade
             *
             * @param first the first object to be compared.
             * @param second the second object to be compared.
             * @return negative int if 1st entry is less than 2nd
             *         zero if 1st entry is equal to 2nd
             *         positive int if 1st entry is greater than 2nd
             */
            @Override
            public int compare(CollectionEntry first, CollectionEntry second) {
                Card firstCard = first.getCard();
                Card secondCard = second.getCard();

                int result = firstCard.getName().compareToIgnoreCase(secondCard.getName());
                if (result != 0) {
                    return result;
                }

                result = firstCard.getSet().compareTo(secondCard.getSet());
                if (result != 0) {
                    return result;
                }

                return CardComparisonHelper.compareGrades(firstCard, secondCard);
            }
        });

        return sortedEntries;
    }
}