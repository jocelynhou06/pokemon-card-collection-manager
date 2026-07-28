import java.util.*;

/**
 * Represents collection of Pokemon cards and corresponding quantities
 * Collection supports card sorting through Strategy pattern
 *                     change notifications through Observer pattern
 *                     iteration over its unique cards
 */
public class PokemonCollection implements Iterable<Card>, CardSubject {
    private final List<CollectionEntry> entries;
    private final Set<CardObserver> observers;
    private CardSortStrategy sortStrategy;

    /**
     * Construct empty collection using main.java.NoSortStrategy as default sorting strategy
     */
    public PokemonCollection() {
        entries = new ArrayList<>();
        observers = new LinkedHashSet<>();
        sortStrategy = new NoSortStrategy();
    }

    /**
     * Constructs empty collection with specified sorting strategy
     *
     * @param sortStrategy the strategy used to sort collection entries
     */
    public PokemonCollection(CardSortStrategy sortStrategy) {
        this();
        this.sortStrategy = Objects.requireNonNull(sortStrategy, "Sort strategy cannot be null.");
    }

    /**
     * Returns unmodifiable list containing each unique card in collection
     *
     * @return unique cards in the collection
     */
    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();

        for (CollectionEntry entry : entries) {
            cards.add(entry.getCard());
        }

        return Collections.unmodifiableList(cards);
    }

    /**
     * Returns unmodifiable copy of collection's entries
     *
     * @return collection entries
     */
    public List<CollectionEntry> getEntries() {
        return List.copyOf(entries);
    }

    /**
     * Returns total number of cards in collection including duplicates
     *
     * @return the total number of cards
     */
    public int size() {
        int total = 0;

        for (CollectionEntry entry : entries) {
            total += entry.getQuantity();
        }

        return total;
    }

    /**
     * Returns number of unique cards in collection
     *
     * @return the number of unique cards
     */
    public int uniqueSize() {
        return entries.size();
    }

    /**
     * Adds one copy of specified card to the collection
     * If the card already exists, its quantity is increased else a new collection entry is created
     *
     * @param card the card to add
     */
    public void addCard(Card card) {
        Objects.requireNonNull(card, "main.java.Card cannot be null.");
        CollectionEntry entry = findEntry(card);

        if (entry == null) {
            entries.add(new CollectionEntry(card));
        }
        else {
            entry.increaseQuantity();
        }

        notifyCardAdded(card);
    }

    /**
     * Removes one copy of specifiedd card from the collecction
     * If the card's quantity reaches zero, the collection entry is removed
     *
     * @param card the card to remove
     * @return true if card is removed
     *         false if card was not found
     */
    public boolean removeCard(Card card) {
        Objects.requireNonNull(card, "main.java.Card cannot be null.");
        Iterator<CollectionEntry> iterator = entries.iterator();

        while (iterator.hasNext()) {
            CollectionEntry entry = iterator.next();

            if (entry.getCard().equals(card)) {
                entry.decreaseQuantity();

                if (entry.getQuantity() == 0) {
                    iterator.remove();
                }

                notifyCardRemoved(card);
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether collection contains specified card
     *
     * @param card the card to check for
     * @return true if card is present
     *         false elsewise
     */
    public boolean contains(Card card) {
        Objects.requireNonNull(card, "main.java.Card cannot be null.");
        return findEntry(card) != null;
    }

    /**
     * Returns quantity of specified card in collection
     *
     * @param card the card whose quantity is wanted
     * @return card's quantity or 0 if card isn't in collection
     */
    public int getQuantity(Card card) {
        Objects.requireNonNull(card, "main.java.Card cannot be null.");
        CollectionEntry entry = findEntry(card);

        if (entry == null) {
            return 0;
        }

        return entry.getQuantity();
    }

    /**
     * Changes sorting strategy used by the collection
     *
     * @param sortStrategy the replacing sorting strategy
     */
    public void setSortStrategy(CardSortStrategy sortStrategy) {
        this.sortStrategy = Objects.requireNonNull(sortStrategy, "Sort strategy cannot be null.");
    }

    /**
     * Resets collection's sorting strategy to default main.java.NoSortStrategy
     */
    public void clearSortStrategy() {
        sortStrategy = new NoSortStrategy();
    }

    /**
     * Returns collection entries arranged using current sorting strategy
     *
     * @return sorted collection entries
     */
    public List<CollectionEntry> getSortedEntries() {
        return sortStrategy.sort(new ArrayList<>(entries));
    }

    /**
     * Finds collection entry associated with specified card
     *
     * @param card the card to search for
     * @return the matching collection entry or null if card is not present
     */
    private CollectionEntry findEntry(Card card) {
        Objects.requireNonNull(card, "main.java.Card cannot be null.");

        for (CollectionEntry entry : entries) {
            if (entry.getCard().equals(card)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Return iterator over the unique cards in the collection
     *
     * @return an iterator over collection's cards
     */
    @Override
    public Iterator<Card> iterator() {
        return getCards().iterator();
    }

    @Override
    public void addObserver(CardObserver observer) {
        Objects.requireNonNull(observer, "Observer cannot be null.");
        observers.add(observer);
    }

    @Override
    public void removeObserver(CardObserver observer) {
        Objects.requireNonNull(observer, "Observer cannot be null.");
        observers.remove(observer);
    }

    @Override
    public void notifyCardAdded(Card card) {
        for (CardObserver observer : observers) {
            observer.cardAdded(card);
        }
    }

    @Override
    public void notifyCardRemoved(Card card) {
        for (CardObserver observer : observers) {
            observer.cardRemoved(card);
        }
    }
}