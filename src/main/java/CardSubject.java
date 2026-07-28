/**
 * Represents subject that notifies observers when change occurs.
 */
 interface CardSubject {
    void addObserver(CardObserver observer);
    void removeObserver(CardObserver observer);
    void notifyCardAdded(Card card);
    void notifyCardRemoved(Card card);
}