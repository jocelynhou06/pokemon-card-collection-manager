/**
 * Represents an observer that's notified when Pokemon Collection changes.
 */
public interface CardObserver {
    void cardAdded(Card card);
    void cardRemoved(Card card);
}