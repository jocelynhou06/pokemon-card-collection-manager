import java.util.Objects;

/**
 * Represents unique card in a collection along with # of copies
 */
public class CollectionEntry {
    private final Card aCard;
    private int aQuantity;

    /**
     * Constructs collection entry with initial quantity of 1
     * @param pCard the specified card to add to collection entry
     */
    public CollectionEntry(Card pCard) {
        aCard = Objects.requireNonNull(pCard, "main.java.Card cannot be null.");
        aQuantity = 1;
    }

    public Card getCard() {
        return aCard;
    }

    public int getQuantity() {
        return aQuantity;
    }

    void increaseQuantity() {
        aQuantity++;
    }

    void decreaseQuantity() {
        if (aQuantity <= 0) {
            throw new IllegalStateException("Quantity cannot be decreased below zero.");
        }
        aQuantity--;
    }
}
